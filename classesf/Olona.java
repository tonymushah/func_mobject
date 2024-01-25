package classesf;

public class Olona{
    String nom;
    String dtn;
    int age;
    String sehatra;
    boolean mariage;
    public void setMariage(boolean mariage) {
        this.mariage = mariage;
    }

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
    public String getSehatra() {
        return sehatra;
    }
    public void setSehatra(String sehatra) {
        this.sehatra = sehatra;
    }   

    public Olona(String nom, int age, String dtn, String sehatra, boolean mariage) {
        this.setAge(age);
        this.setDtn(dtn);
        this.setNom(nom);
        //TODO Auto-generated constructor stub
        this.setSehatra(sehatra);
        this.setMariage(mariage);
    }
    public Olona() {
        
    }
}
