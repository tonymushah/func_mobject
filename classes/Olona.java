package classes;

public class Olona extends Vivant{
    String sehatra;
    boolean mariage;
    public String getSehatra() {
        return sehatra;
    }
    public void setSehatra(String sehatra) {
        this.sehatra = sehatra;
    }   
    public Olona(){
        super();
    } 
    public void setMariage(boolean mariage) {
        this.mariage = mariage;
    }
    public Olona(String nom, int age, String dtn, String sehatra, boolean mariage) {
        super(nom, age, dtn);
        //TODO Auto-generated constructor stub
        this.setSehatra(sehatra);
        this.setMariage(mariage);
    }
    
}
