import java.util.Date;

import classes.Personne;
import utils.array_JTable.ArrFrame;

public class R0Main {
    public static void main(String[] args) {
        Personne[] test = new Personne[5];
        test[0] = new Personne("Burnice", new Date(89, 2, 15));
        test[1] = new Personne("Oswaldo", new Date(120, 8, 25));
        test[2] = new Personne("Jamaal", new Date(79, 5, 2));
        test[3] = new Personne("Javier", new Date(99, 3, 5));
        test[4] = new Personne("Marvin", new Date(60, 7, 26));
        ArrFrame testd = new ArrFrame(test);
    }
}
