package classesf;

public class Vivant extends Object{
    String nom;
    String dtn;
    int age;
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
    public Vivant(String nom, int age, String dtn){
        this.setAge(age);
        this.setDtn(dtn);
        this.setNom(nom);
    }
}
