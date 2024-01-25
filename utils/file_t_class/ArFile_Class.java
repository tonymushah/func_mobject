package utils.file_t_class;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

import utils.*;

public class ArFile_Class {
    File to_use;
    Object[] to_create;
    File_Class[] to_insert;
    public void setTo_create(Object[] to_create) {
        this.to_create = to_create;
    }
    public void setTo_insert(File_Class[] to_insert) {
        this.to_insert = to_insert;
    }
    public void setTo_use(File to_use) {
        this.to_use = to_use;
    }
    public Object[] getTo_create() {
        return to_create;
    }
    public File_Class[] getTo_insert() {
        return to_insert;
    }
    public File getTo_use() {
        return to_use;
    }
    public String getArClassName(){
        String[] sq1 = TUtils.getLine(to_use).split("###");
        String classname = sq1[sq1.length - 1].split("//")[0].split(";")[0].replaceAll("[\\[]L", "");
        return classname;
    }
    public String getArClassNameR(){
        String[] sq1 = TUtils.getLine(to_use).split("###");
        String classname = sq1[sq1.length - 1].split("//")[0].split(";")[0];
        return classname;
    }
    public String getArrayData(){
        String[] sq1 = TUtils.getLine(to_use).split("###");
        String classname = sq1[sq1.length - 1].split("//")[1];
        return classname;
    }
    public int getArrayLength(){
        String[] sq1 = TUtils.getLine(to_use).split("###");
        String classname = sq1[sq1.length - 1].split("//")[0].split(";")[1];
        return Integer.valueOf(classname);
    }
    public String[] getArrayDatas(){
        return this.getArrayData().split(";;");
    }
    public void initialise_toinsert(){
        String[] data = this.getArrayDatas();
        Class tous = null;
        try {
            tous = Class.forName(this.getArClassName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.setTo_create((Object[]) Array.newInstance(tous, this.getArrayLength()));
        this.setTo_insert(new File_Class[this.getArrayLength()]);
        for (int i = 0; i < data.length; i++) {
            this.to_insert[i] = new File_Class(new File(this.to_use.getParent() + "/" + data[i].split("::")[1]));
        }
    }
    public void init_Tocreate(){
        this.initialise_toinsert();
        for (int i = 0; i < to_create.length; i++) {
            this.to_create[i] = this.to_insert[i].getTo_create();
        }
    }
    public ArFile_Class(File to_use){
        this.setTo_use(to_use);
        this.init_Tocreate();
    }

}
