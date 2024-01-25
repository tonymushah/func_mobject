package classes;

import java.util.Date;

public class Personne {
    String nom;
    Date dtn;
    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Date getDtn() {
        return dtn;
    }
    public String getNom() {
        return nom;
    }
    public Personne(){

    }
    public Personne(String nom, Date dtn){
        this.setDtn(dtn);
        this.setNom(nom);
    }
}