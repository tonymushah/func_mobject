package classes;

import java.lang.reflect.Field;

import utils.TUtils;

public class Vivant extends Object{
    protected String nom;
    protected String dtn;
    protected int age;
    public int getAge() {
        return age;
    }
    public String getDtn() {
        return dtn;
    }
    public String getNom() {
        return nom;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setDtn(String dtn) {
        this.dtn = dtn;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Vivant(){

    }
    public Vivant(String nom, int age, String dtn){
        this.setAge(age);
        this.setDtn(dtn);
        this.setNom(nom);
    }
    public Field[] myFields(){
        return TUtils.getAllFields(this);
    }
}
