package utils.swing;

import javax.swing.JComboBox;

public class TComboBox extends JComboBox<String>{
    String[] frontend;
    String[] output;
    public void setFrontend(String[] frontend) {
        this.frontend = frontend;
        /*this.removeAllItems();
        for (String string : frontend) {
            this.addItem(string);
        }*/
    }
    public void setOutput(String[] output) {
        this.output = output;
    }
    public void setArray(String[][] input){
        this.setFrontend(input[0]);
        this.setOutput(input[1]);
    }
    public String[] getFrontend() {
        return frontend;
    }
    public String[] getOutput() {
        return output;
    }
    public String getSelected(){
        return this.output[this.getSelectedIndex()];
    }
    public TComboBox(){
        super();
    }
    public TComboBox(String[][] input){
        super(input[0]);
        this.setArray(input);
    }
}
