package utils.forms;

import java.lang.reflect.Field;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import utils.TUtils;
import utils.listeners.ArgPanel.ArOpen_Field_info;
import utils.swing.TComboBox;
//import utils.listeners.ArgPanel.Open_Field_info;
import utils.swing.Tutils_Swing;

public class ArgPanel extends JPanel{
    JComponent input;
    JLabel argLabel;
    Object to_ouse;
    Field to_use;
    public void setTo_ouse(Object to_ouse) {
        this.to_ouse = to_ouse;
    }
    public Object getTo_ouse() {
        return to_ouse;
    }
    public JComponent getInput() {
        return input;
    }
    public void setInput(JComponent input) {
        this.input = input;
        System.out.println(input);
    }
    public void setTo_use(Field to_use) {
        this.to_use = to_use;
    }
    public void setAccessibility(boolean bool){
        this.to_use.setAccessible(bool);
    }
    public Field getTo_use() {
        return to_use;
    }
    public String getInTField(){
        return Tutils_Swing.get_data(input);
    }
    public void addJPanel(){
        this.add(new JPanel());
    }
    public void addLabel(String text){
        this.setArgLabel(new JLabel(text));
    }
    public void setArgLabelText(String text){
        this.argLabel.setText(text);
    }
    public void setInputText(String text){
        if(input instanceof JTextField){
            ((JTextField) (this.input)).setText(text);
        }
    }
    public Object getFieldContent(){
        this.setAccessibility(true);
        Object returns = null;
        try {
            returns = this.to_use.get(to_ouse);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        this.setAccessibility(false);
        return returns;
    }
    public void udpateInField(){
        String input = TUtils.to_stringField(to_ouse, to_use);
        this.setInputText(input);
        
    }
    public void setArgLabel(JLabel argLabel) {
        this.argLabel = argLabel;
    }
    public JLabel getArgLabel() {
        return argLabel;
    }
    public void launch_graph(){ 
        try {
            this.udpateInField();
        } catch (Exception e) {
            //TODO: handle exception
        }
        // NOTE box Layout   
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        // NOTE tgv :3
        this.addJPanel();
        this.add(this.argLabel);
        this.addJPanel();
        if (TUtils.isBasicClasses(this.to_use)) {
            if(this.to_use.getType().getName().compareTo("boolean") == 0){
                String[][] od = new String[2][2];
                od[0][0] = "Oui";
                od[0][1] = "Non";

                od[1][0] = "true";
                od[1][1] = "false";

                this.setInput(new TComboBox(od));

                this.add(this.input);
            }else{
                this.add(this.input);
                if (this.input instanceof JComboBox) {
                    System.out.println(input.getClass().getName());
                    //this.setInputSize(100, 15);
                }
            }
        }else if(to_use.getType().getName().indexOf("[L") != -1){
            this.setInput(Tutils_Swing.addJButton(this, to_use.getType().getName()));
            this.input.addMouseListener(new ArOpen_Field_info(this));
            this.add(this.input);
        }else{
            this.setInput(Tutils_Swing.addJButton(this, to_use.getType().getName()));
            this.input.addMouseListener(new ArOpen_Field_info(this));
            this.add(this.input);
        }
        this.addJPanel();
        this.doLayout();
        
    }
    public void setInputSize(int width, int height){
        this.input.setPreferredSize(new DimensionUIResource(width, height));
        this.input.setSize(new DimensionUIResource(width, height));
    }
    public ArgPanel(Field to_use, Object to_ouse){
        this.setTo_ouse(to_ouse);
        this.setTo_use(to_use);
        this.addLabel(this.to_use.getName());
        this.setInput(new JTextField());
        this.launch_graph();
    }
    public ArgPanel(Field to_use, Object to_ouse, String text){
        this.setTo_ouse(to_ouse);
        this.setTo_use(to_use);
        this.addLabel(text);
        this.setInput(new JTextField());
        this.launch_graph();
    }
    public ArgPanel(Field to_use, Object to_ouse, JComponent input){
        this.setTo_ouse(to_ouse);
        this.setTo_use(to_use);
        this.addLabel(this.to_use.getName());
        this.setInput(input);
        this.launch_graph();
    }
    public ArgPanel(Field to_use, Object to_ouse, JComponent input, String text){
        this.setTo_ouse(to_ouse);
        this.setTo_use(to_use);
        this.addLabel(text);
        this.setInput(input);
        this.launch_graph();
    }
    public ArgPanel(Field to_use, Object to_ouse, int width, int height){
        this.setTo_ouse(to_ouse);
        this.setTo_use(to_use);
        this.setInput(new JTextField());
        this.setInputSize(width, height);
        this.launch_graph();
    }
    public void setInputToField(){
        TUtils.setinField(to_ouse, this.getInTField(), to_use);
    }
}
