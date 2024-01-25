package humain;

import java.util.Set;

public class Etudiant {
    String numero;
    boolean estScientifique;
    String province;
    String remarque;
    public void setEstScientifique(boolean estScientifique) {
        this.estScientifique = estScientifique;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }public void setProvince(String province) {
        this.province = province;
    }
    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
    public String getNumero() {
        return numero;
    }
    public String getProvince() {
        return province;
    }
    public String getRemarque() {
        return remarque;
    }
    public Etudiant(){

    }
    public Etudiant(String numero, boolean estScientifique, String province, String remarque){
        this.setEstScientifique(estScientifique);
        this.setNumero(numero);
        this.setRemarque(remarque);
        this.setProvince(province);
    }
}
