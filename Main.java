import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import classes.*;
import classesf.Vivant;
import utils.*;
import utils.array_JTable.ArrFrame;
import utils.array_JTable.Ju_JTextField;
import utils.class_t_file.*;
import utils.file_t_class.ArFile_Class;
import utils.file_t_class.File_Class;
import utils.search.Search_Frame;
import utils.swing.TComboBox;

public class Main {
    public static void main(String[] args) throws Exception{
        Object[] chiens = new Chien[5];

        chiens[0] = new Chien("Iron", 15, "13-06-05", "berger");
        chiens[1] = new Chien("Dian", 11, "23-01-15", "chien_de_salon");
        chiens[2] = new Chien("Piff", 3, "01-06-16", "berger");
        chiens[3] = new Chien("Balt", 16, "23-09-06", "Gasy");
        chiens[4] = new Chien("Mars", 1, "13-06-22", "Gasy");

        /*Method use = chiens[0].getClass().getMethod("getAge");
        double op = (int) use.invoke(chiens[0]);
        System.out.println(op);*/
        
        //Tutils.pr_methods_info(chiens[0]);
        //try {
        //NOTE test somme, max, min
        /*System.out.println("somme d'age = " + Tutils.fsum(chiens, "getAge"));
        System.out.println("Le vivant ayant le min d'age = " + Tutils.fmin(chiens, "getAge"));
        System.out.println("Le vivant ayant le max d'age = " + Tutils.fmax(chiens, "getAge"));
        System.out.println("Le moyenne d'age = " + Tutils.fmoyen(chiens, "getAge"));*/
        //Integer qa = 0;
        
        /*Field[] tFields = (Field[]) Tutils.getAllFields(chiens[0]);
        for (Field field : tFields) {
            field.setAccessible(true);
            for (int i = 0; i < chiens.length; i++) {
                System.out.println(i + " : ");
                System.out.println(field.getName() + " = " + field.get(chiens[i]));
            }
        }*/

        //Class_File test = new Class_File(chiens[1], "data/lol/");
        //System.out.println(chiens[4].toString());/68a9209900bddf0a15db3c459b505030/2
        //Tutils.showObject_info(chiens[4]);
        //System.out.println(Class.forName("java.lang.Double").cast(7e1));
        /*TCeutils object = new TCeutils(chiens[0]);
        System.out.println(object.getInField("nom"));*/
        //ArClass_File syntax = new ArClass_File(chiens, "data/");
        /*} catch (Exception e) {
            //TODO: handle exception
        }*/

        //File_Class l = new File_Class(test.getFishing());
        //new TestFrame(chiens[0]);

        String[][] race = new String[2][5];
        // NOTE frontend race
            race[0][0] = "Berger Allemand";
            race[0][1] = "Berger Suisse";
            race[0][2] = "Chien Malagasy";
            race[0][3] = "Chien de salon pouff";
            race[0][4] = "Bouldog";
        // NOTE output race
            race[1][0] = "berger_allemand";
            race[1][1] = "berger_suisse";
            race[1][2] = "gasy";
            race[1][3] = "chien_de_salon";
            race[1][4] = "bouldog";

        //TComboBox input = new TComboBox(race);
        //JComboBox inpsut = new ;
        ArFile_Class test =  new ArFile_Class(new File("data/[Chien__4b1210eeD9/[Chien__4b1210ee.Tclass"));
        //System.out.println(test.getTo_create()[0]);
        ArrFrame frame = new ArrFrame(test.getTo_create());
        Ju_JTextField[] md = frame.getArJtable().getContent();
        for (int i = 0; i < md.length; i++) {
            md[i].getInfo().getTo_show().splitArgPanelPosition("race", "age");
            md[i].getInfo().getTo_show().change_argPanelInput("race", new TComboBox(race));
        }
    }
}