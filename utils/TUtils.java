package utils;

import java.io.*;
import java.lang.reflect.*;
import java.nio.*;
import java.util.*;

import utils.class_t_file.ArClass_File;
import utils.file_t_class.ArFile_Class;

public class TUtils {
    public static String whoami(Object object){
        String returns = "";
        returns = object.getClass().getName();
        return returns;
    }

    public static String[] whoamiA(Object[] objects){
        String[] returns = new String[objects.length];
        for (int i = 0; i < returns.length; i++) {
            returns[i] = whoami(objects[i]);
        }
        return returns;
    }
    public static void pr_whoamiA(Object[] objects) {
        String[] show = whoamiA(objects);
        for (int i = 0; i < show.length; i++) {
            System.out.println(i + " : " + show);
        }
    }
    public static String[] methods_info(Object object){
        Method[] methods = object.getClass().getMethods();
        String[] returns = new String[methods.length];
        for (int i = 0; i < returns.length; i++) {
            returns[i] = "" + methods[i].getReturnType().getName() + " " + methods[i].getName() + "(";
            Class[] args = methods[i].getParameterTypes();
            if(args == null){
                
            }else if (args.length == 1){
                returns[i] = returns[i] + "" + args[0].getName();
            }else{
                for (Class class1 : args) {
                    returns[i] = returns[i] + "" + class1.getTypeName()+ ", ";
                }
            }
            returns[i] = returns[i] + ")";
        }
        return returns;
    }
    public static void pr_methods_info(Object object) {
        String[] strings = methods_info(object);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(i + " --> " + strings[i]);
        }
    }

    public static double fsum(Object[] objects, String gmethod){
        double returns = 0;
        Integer p = 0;
        for (int i = 0; i < objects.length; i++) {
            try {
                Method use = objects[i].getClass().getMethod(gmethod);
                double sqp;
                if(use.invoke(objects[i]).getClass().getName() == p.getClass().getName()){
                    sqp = (int) use.invoke(objects[i]);
                }else{
                    sqp = (double) use.invoke(objects[i]);
                }
                returns = returns + sqp;
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        return returns;
    }

    
    public static double[] fdoubleA(Object[] objects, String gmethod){
        double[] returns = new double[objects.length];
        Integer p = 0;
        for (int i = 0; i < objects.length; i++) {
            try {
                Method use = objects[i].getClass().getMethod(gmethod);
                if(use.invoke(objects[i]).getClass().getName() == p.getClass().getName()){
                    returns[i] = (int) use.invoke(objects[i]);
                }else{
                    returns[i] = (double) use.invoke(objects[i]);
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        return returns;
    }
    public static double fmax(Object[] objects, String gmethod){
        double returns = 0;
        double[] returnis = fdoubleA(objects, gmethod);
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < returnis.length; j++) {
                if(returnis[j] > returns){
                    returns = returnis[j];
                    returnis[j] = 0;
                }
            }
        }
        return returns;
    }
    public static double fmin(Object[] objects, String gmethod){
        double returns = fmax(objects, gmethod);
        double[] returnis = fdoubleA(objects, gmethod);
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < returnis.length; j++) {
                if(returnis[j] < returns){
                    returns = returnis[j];
                    //returnis[j] = 0;
                }
            }
        }
        return returns;
    }
    public static double fmoyen(Object[] objects, String gmethod) {
        return (fsum(objects, gmethod) / objects.length);
    }
    public static Field[] getSuperFields(Object object){
        if(object.getClass().getSuperclass().getName() != Object.class.getName()){
            return object.getClass().getSuperclass().getDeclaredFields();
        }else{
            return null;
        }
    }

    public static Field[] getAllFields(Object object) {
        if(object.getClass().getSuperclass().getName() != Object.class.getName()){
            Field[] cfields = object.getClass().getDeclaredFields();
            Field[] sFields = getSuperFields(object);
            Field[] returns = new Field[cfields.length + sFields.length];
            int i = 0;
            for (int j1 = 0; j1 < sFields.length; j1++) {
                returns[i] = sFields[j1];
                i++;
            }
            for (int j = 0; j < cfields.length; j++) {
                returns[i] = cfields[j];
                i++;
            }
            return returns;
        }else{
            return object.getClass().getDeclaredFields();
        }
        
    }
    public static Field getFieldbyName(Object object, String name){
        Field[] all = getAllFields(object);
        for (Field field : all) {
            if (field.getName().compareTo(name) == 0) {
                return field;
            }
        }
        throw new NoSuchFieldError("Field called " + name);
    }
    public static Method[] getSuperMethods(Object object){
        if(object.getClass().getSuperclass().getName() != Object.class.getName()){
            return object.getClass().getSuperclass().getMethods();
        }
        throw new NoSuchMethodError("This class" + object.getClass().getName() + " has no super class (only Object)");
    }
    public static Method[] getAllMethods(Object object) {
        if(object.getClass().getSuperclass().getName() != Object.class.getName()){
            Method[] cfields = object.getClass().getMethods();
            Method[] sFields = getSuperMethods(object);
            Method[] returns = new Method[cfields.length + sFields.length];
            int i = 0;
            for (int j1 = 0; j1 < sFields.length; j1++) {
                returns[i] = sFields[j1];
                i++;
            }
            for (int j = 0; j < cfields.length; j++) {
                returns[i] = cfields[j];
                i++;
            }
            return returns;
        }else{
            return object.getClass().getDeclaredMethods();
        }
        
    }
    public static Method getMethodbyName(Object object, String name){
        Method[] methods = getAllMethods(object);
        for (Method method : methods) {
            if(method.getName() == name){
                return method;
            }
        }
        throw new NoSuchMethodError("No method named" + name); 
    }
    public static Method getMethodbyName(Class to_use, String name){
        Method[] methods = to_use.getMethods();
        for (Method method : methods) {
            if(method.getName() == name){
                return method;
            }
        }
        throw new NoSuchMethodError("No method named" + name); 
    }
    public static String to_stringField(Object to_use, Field to_take){
        String returns = "";
        try {
            to_take.setAccessible(true);
            Object interc = to_take.get(to_use);
            if(interc.getClass() == String.class){
                returns = (String) interc;
            }else if(interc.getClass() == Integer.class){
                returns = "" + ((int) interc);
            } 
            else if(interc.getClass() == Long.class){
                returns = "" + ((long) interc);
            }else if(interc.getClass() == Double.class){
                returns = "" + ((double) interc);
            }else if(interc.getClass() == float.class){
                returns = "" + ((float) interc);
            } 
            to_take.setAccessible(false);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return returns;
    }
    public static String[] basic_classes(){
        String[] returns = new String[6];
        returns[0] = "Integer";
        returns[1] = "Boolean";
        returns[2] = "Float";
        returns[3] = "Double";
        returns[4] = "Long";
        returns[5] = "Short";
        return returns;
    }
    public static String[] basic_classic(){
        String[] returns = new String[8];
        returns[0] = "int";
        returns[1] = "boolean";
        returns[2] = "float";
        returns[3] = "double";
        returns[4] = "long";
        returns[5] = "short";
        returns[6] = "char";
        returns[7] = "java.lang.String";
        return returns;
    }
    public static void setinField(Object to_use, Object value, Field to_take){
        try {
            to_take.setAccessible(true);
            if(to_take.getType().getName() == value.getClass().getName()){
                to_take.set(to_use, value);
            }else{
                for (int i = 0; i < basic_classes().length; i++) {
                    Class toc_use = Class.forName("java.lang." + basic_classes()[i]);
                    try {
                        switch (i) {
                            case 0:
                                to_take.setInt(to_use, Integer.valueOf((String) value));
                                break;
                            case 1:
                                to_take.setBoolean(to_use, Boolean.valueOf((String) value));
                                break;
                            case 2:
                                to_take.setFloat(to_use, Float.valueOf((String) value));
                                break;
                            case 3:
                                to_take.setDouble(to_use, Double.valueOf((String) value));
                                break;
                            case 4:
                                to_take.setLong(to_use, Long.valueOf((String) value));
                                break;
                            case 5:
                                to_take.setShort(to_use, Short.valueOf((String) value));
                                break;
                            
                            default:
                                break;
                        }
                    } catch (Exception e) {
                        //TODO: handle exception
                        e.printStackTrace();
                    }
                    
                }
            }
            to_take.setAccessible(false);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }
    public static boolean isBasicClasses(Object to_use) {
        for (String basic_classe : basic_classic()) {
            if(to_use.getClass().getName().compareTo(basic_classe) == 0){
                return true;
            }
        }
        for (String basic_classe : basic_classes()) {
            if(to_use.getClass().getName().compareTo("java.lang." + basic_classe) == 0){
                return true;
            }
        }
        return false;
    }
    public static boolean isBasicClasses(Field to_use) {
        for (String basic_classe : basic_classic()) {
            if(to_use.getType().getName().compareTo(basic_classe) == 0){
                return true;
            }
        }
        for (String basic_classe : basic_classes()) {
            if(to_use.getType().getName().compareTo("java.lang." + basic_classe) == 0){
                return true;
            }
        }
        return false;
    }
    public static Object[] getInInfoField(Object object){
        Field[] fields = getAllFields(object);
        Object[] returns = new Object[fields.length];
        for (int i = 0; i < returns.length; i++) {
            fields[i].setAccessible(true);
            try {
                returns[i] = fields[i].get(object);
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            fields[i].setAccessible(false);
        }
        return returns;
    }
    public static void showObject_info(Object object){
        System.out.println(object.getClass().getName() + " > " + object.toString());
        Field[] fields = getAllFields(object);
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                System.out.println("==> " + field.getType().getName() + " : " + field.get(object));
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            field.setAccessible(false);
        }
        System.out.println("---------------------");
    }
    public static BufferedWriter BufferedFileWriter(File file) {
        BufferedWriter returns = null;
        try {
            returns = new BufferedWriter(new FileWriter(file, true));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return returns;
    }
    public static void write_to_file(File to_write, String input) {
        BufferedWriter to_use = BufferedFileWriter(to_write);
        try {
            to_use.write(input);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            to_use.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static BufferedReader bufferedFileReader(File file) {
        BufferedReader returns = null;
        try {
            returns = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return returns;
    }
    public static String getLine(File file){
        String returns = "";
        try {
            returns = bufferedFileReader(file).readLine();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return returns;
    }
    public static String remplace_str(String to_use, String to_replace, String to_insert){
        to_use = to_use.replaceAll(to_replace, to_insert);
        return to_use;
    }
    public static int rand(int limits){
        Random random = new Random();
        return random.nextInt(limits);
    }
    public static double isum(Object[] objects, String arg){
        double returns = 0;
        for (Object object : objects) {
            try {
                Field input = getFieldbyName(object, arg);
                input.setAccessible(true);
                System.out.println((input.get(object)));
                returns = returns + Double.valueOf(String.valueOf((input.get(object))));
                input.setAccessible(false);
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        return returns;
    }
    public static double imoyern(Object[] objects, String arg){
        double returns = 0;
        for (Object object : objects) {
            try {
                Field input = getFieldbyName(object, arg);
                input.setAccessible(true);
                returns = returns + Double.valueOf(String.valueOf((input.get(object))));
                input.setAccessible(false);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Tutils.sum()");
            }
        }
        return (returns / objects.length);
    }
    public static double imax(Object[] objects, String arg) {
        double max = 0;
        for (int i = 0; i < objects.length; i++) {
            if(objects[i] != null){
                Field to_use = getFieldbyName(objects[i], arg);
                to_use.setAccessible(true);
                double to_cmp = 0;
                try {
                    to_cmp = Double.valueOf(String.valueOf((to_use.get(objects[i]))));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
                if (max < to_cmp) {
                    max = to_cmp;
                }
                to_use.setAccessible(false);
            }
        }
        return max;
    }
    public static double imin(Object[] objects, String arg) {
        double min = imax(objects, arg);
        for (int i = 0; i < objects.length; i++) {
            if(objects[i] != null){
                Field to_use = getFieldbyName(objects[i], arg);
                to_use.setAccessible(true);
                double to_cmp = 0;
                try {
                    to_cmp = Double.valueOf(String.valueOf((to_use.get(objects[i]))));
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (min > to_cmp) {
                    min = to_cmp;
                }
                to_use.setAccessible(false);
            }
        }
        return min;
    }
    public static Object[] add(Object[] array, Object value){
        Class to_use = array[0].getClass();
        Object[] returns = (Object[]) Array.newInstance(to_use, array.length +1 );
        for (int i = 0; i < array.length; i++) {
            returns[i] = array[i];
        }
        returns[returns.length - 1] = value;
        return returns;
    }
    public static Object[] addNew(Object[] array){
        Constructor to_use = null;
        try {
            to_use = array[0].getClass().getConstructor();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Object returns = null;
        try {
            returns = to_use.newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return add(array, returns);
    }
    public static Object[] clone(Object[] array){
        ArClass_File exp = new ArClass_File(array, "data/");
        ArFile_Class clone = new ArFile_Class(exp.getArray_file());
        return clone.getTo_create();
    }
    public static Object[] sortDESC(Object[] array, String arg){
        //Object[] to_use = array.clone();
        Object[] to_use = clone(array);
        Object[] returns = (Object[]) Array.newInstance(array[0].getClass(), array.length);
        for (int i = 0; i < returns.length; i++) {
            double max = imax(to_use, arg);
            System.out.println(max);
            try {
                for (int z = 0; z < to_use.length; z++) {
                    Field to_fuse = getFieldbyName(array[z], arg);
                    to_fuse.setAccessible(true);
                    double to_cmp = 0;
                    try {
                        to_cmp = Double.valueOf(String.valueOf((to_fuse.get(to_use[z]))));
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    to_fuse.setAccessible(false);
                    if(to_cmp == max){
                        returns[i] = array[z];
                        to_use[z] = null;
                        break;
                    }
                }
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        return returns;
    }
    public static Object[] invOrder(Object[] objects){
        Object[] returns = (Object[]) Array.newInstance(objects[0].getClass(), objects.length);
        for (int i = 0; i < returns.length; i++) {
            returns[i] = objects[(returns.length - 1) - i];
        }
        return returns;
    }
    public static Object[] sortASC(Object[] array, String arg){
        return invOrder(sortDESC(array, arg));
    }
    public static int search_length(Object[] array, String text){
        int number = 0;
        for (Object object : array) {
            TCeutils to_use = new TCeutils(object);
            for (int i = 0; i < to_use.getFieldslength() ; i++) {
                if(String.valueOf(to_use.getInField(to_use.getFields()[i])).indexOf(text) != -1){
                    number++;
                    break;
                }
            }
        }
        return number;
    }
    public static Object[] search(Object[] array, String text){
        if(search_length(array, text) <= 0 ) {
            throw new NoSuchElementException("No fields that have the letter " + text);
        } else {
            Object[] returns = (Object[]) Array.newInstance(array[0].getClass(), search_length(array, text));
            int number = 0;
            for (Object object : array) {
                TCeutils to_use = new TCeutils(object);
                for (int i = 0; i < to_use.getFieldslength() ; i++) {
                    if(String.valueOf(to_use.getInField(to_use.getFields()[i])).indexOf(text) != -1){
                        returns[number] = object;
                        number++;
                        break;
                    }
                }
            }
            return returns;
        }
    }
    public static Object[] deleteN(Object[] array, int to_remove){
        Object[] clone = array.clone();
        Object[] returns = (Object[]) Array.newInstance(array[0].getClass(), array.length - 1);
        if (to_remove >= array.length && to_remove < 0) {
            throw new ArrayIndexOutOfBoundsException("can't delete the index " + to_remove + " of the array " + array.toString());
        } else {
            clone[to_remove] = null;
            int index = 0;
            for (int i = 0; i < clone.length; i++) {
                if (clone[i] != null) {
                    returns[index] = clone[i];
                    index++;
                }
            }
        }
        return returns;
    }
    public static Object[] deleteN(Object[] array, int[] to_remove){
        Object[] clone = array.clone();
        Object[] returns = (Object[]) Array.newInstance(array[0].getClass(), array.length - to_remove.length);
        for (int to_remodve : to_remove) {
            try {
                if(to_remodve >= array.length && to_remodve < 0){
                    throw new ArrayIndexOutOfBoundsException("can't delete the index " + to_remodve + " of the array " + array.toString());
                }else{
                    clone[to_remodve] = null;
                }
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        int index = 0;
        for (int i = 0; i < clone.length; i++) {
            if (clone[i] != null) {
                returns[index] = clone[i];
                index++;
            }
        }
        return returns;
    }
    public static Object[] split(Object[] objects, int i1, int i2) throws ArrayIndexOutOfBoundsException{
        if(i1 != i2){
            Object[] returns = objects.clone();
            returns[i1] = objects[i2];
            returns[i2] = objects[i1];
            return returns;
        }else{
            throw new ArrayIndexOutOfBoundsException("Cannot split in the same index");
        }
    }
}
