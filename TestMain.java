import java.io.File;

import javax.swing.*;

import classesf.Olona;
import humain.Etudiant;
import utils.TUtils;
import utils.array_JTable.ArrFrame;
import utils.file_t_class.ArFile_Class;
import utils.file_t_class.File_Class;
import utils.forms.ObjetInfo_Fra;
import utils.swing.TComboBox;
import utils.swing.Tutils_Swing;

public class TestMain {
    public static void main(String[] args) {
        String[][] race = new String[2][6];
        // NOTE frontend race
            race[0][0] = "Antananarivo";
            race[0][1] = "Fianarantsoa";
            race[0][2] = "Toamasina";
            race[0][3] = "Mahajanga";
            race[0][4] = "Tulear";
            race[0][5] = "Antsiranana";
        // NOTE output race
            race[1][0] = "Antananarivo";
            race[1][1] = "Fianarantsoa";
            race[1][2] = "Toamasina";
            race[1][3] = "Mahajanga";
            race[1][4] = "Tulear";
            race[1][5] = "Antsiranana";
        //TComboBox input = new TComboBox(race);
        JComponent input = new TComboBox(race);
        
        ObjetInfo_Fra ddd = new ObjetInfo_Fra(new Etudiant("ETU001844", true, "d", ""));
        ddd.getTo_show().change_argPanelInput("province", input);
        ddd.pack();
        //ObjetInfo_Fra tes = new ObjetInfo_Fra(new Olona("Rene", 45, "12-23-2022", "couture", false));
        
    }
}
