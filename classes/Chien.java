package classes;

public class Chien extends Vivant{
    String race;
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public Chien(){
        super();
    }
    public Chien(String nom, int age, String dtn, String race) {
        super(nom, age, dtn);
        //TODO Auto-generated constructor stub
        this.setRace(race);
    }

}
