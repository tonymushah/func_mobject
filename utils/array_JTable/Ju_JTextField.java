package utils.array_JTable;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import utils.*;
import utils.forms.*;
import utils.listeners.Ju_JTextField.Key_ToObject;
import utils.listeners.Ju_JTextField.More_Info;
import utils.listeners.Ju_JTextField.RefreshField;
import utils.listeners.Ju_JTextField.Select_;
import utils.swing.Tutils_Swing;

public class Ju_JTextField extends JPanel{
    ArJtable mother;
    TCeutils to_use;
    JTextField[] textFields;
    ObjetInfo_Fra info;
    JCheckBox check;
    int selected;
    public void setCheck(JCheckBox check) {
        this.check = check;
    }
    public JCheckBox getCheck() {
        return check;
    }
    public void setTo_use(TCeutils to_use) {
        this.to_use = to_use;
    }
    public void setInfo(ObjetInfo_Fra info) {
        this.info = info;
    }
    public ObjetInfo_Fra getInfo() {
        return info;
    }
    public void setTextFields(JTextField[] textFields) {
        this.textFields = textFields;
    }
    public TCeutils getTo_use() {
        return to_use;
    }
    public void update_(){
        for (int i = 0; i < this.textFields.length; i++) {
            this.textFields[i].setText(String.valueOf(to_use.getInField(to_use.getFields()[i])));
        }
        TUtils.showObject_info(to_use.getTo_use());
    }
    public void setInObject(){
        for (int i = 0; i < textFields.length; i++) {
            this.to_use.setInNField(i, this.textFields[i].getText());
        }
    }
    public void setInObjectSeq(){
        try {
            this.mother.setBackup();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        this.setInObject();
        System.out.println("this.setInObject() : vita");
        this.update_();
        System.out.println("this.update_() : vita");
    }
    public void init_text_field(){
        this.setTextFields(new JTextField[to_use.getFields().length]);
        for (int i = 0; i < this.textFields.length; i++) {
            this.textFields[i] = new JTextField(this.to_use.getFields()[i].getName());
            this.textFields[i].setPreferredSize(new DimensionUIResource(100, 25));
            this.textFields[i].addKeyListener(new Key_ToObject(this));
            this.textFields[i].addKeyListener(new More_Info(this));
            this.textFields[i].addKeyListener(new RefreshField(this));
        }
        this.update_();
    }
    public void launch_graph(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        Tutils_Swing.addJPanel(this);
        this.check = new JCheckBox();
        this.check.addMouseListener(new Select_(this));
        this.add(this.check);
        Tutils_Swing.addJPanel(this);
        for (int i = 0; i < this.textFields.length; i++) {
            this.add(this.textFields[i]);
            Tutils_Swing.addJPanel(this);
        }
        this.doLayout();
    }
    public void more_info(){
        this.info.update_();
        this.info.setVisible(true);
    }
    public int getSelected() {
        return selected;
    }
    public void setSelected(int selected) {
        this.selected = selected;
    }
    public void select(){
        this.setSelected((this.getSelected() + 1) % 2);
    }
    public void setMother(ArJtable mother) {
        this.mother = mother;
    }
    public ArJtable getMother() {
        return mother;
    }
    public Ju_JTextField(Object to_show){
        this.setTo_use(new TCeutils(to_show));
        this.init_text_field();
        this.setInfo(new ObjetInfo_Fra(this.to_use.getTo_use(), JFrame.DISPOSE_ON_CLOSE, false));
        this.launch_graph();
    }
    public Ju_JTextField(TCeutils to_use){
        this.setTo_use(to_use);
        this.init_text_field();
        this.setInfo(new ObjetInfo_Fra(this.to_use.getTo_use(), JFrame.DISPOSE_ON_CLOSE, false));
        this.launch_graph();
    }
    public Ju_JTextField(Object to_show, ArJtable mother){
        this.setTo_use(new TCeutils(to_show));
        this.setMother(mother);
        this.init_text_field();
        this.setInfo(new ObjetInfo_Fra(this.to_use.getTo_use(), JFrame.DISPOSE_ON_CLOSE, false));
        this.launch_graph();
    }
    public Ju_JTextField(TCeutils to_use, ArJtable mother){
        this.setTo_use(to_use);
        this.setMother(mother);
        this.init_text_field();
        this.setInfo(new ObjetInfo_Fra(this.to_use.getTo_use(), JFrame.DISPOSE_ON_CLOSE, false));
        this.launch_graph();
    }
}
