package utils.array_JTable;

import java.lang.reflect.Field;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import utils.TUtils;
import utils.listeners.Ju_JBouton.Select_all;
import utils.listeners.Ju_JBouton.Sort_;
import utils.listeners.f_option.Field_Opt;
import utils.swing.Tutils_Swing;

public class Ju_JBouton extends JPanel{
    ArJtable to_use;
    Field[] to_fuse;
    JButton[] to_show;
    F_Option[] info;
    JCheckBox check;
    public void setCheck(JCheckBox check) {
        this.check = check;
    }
    public JCheckBox getCheck() {
        return check;
    }
    public void setTo_show(JButton[] to_show) {
        this.to_show = to_show;
    }
    public void setTo_use(ArJtable to_use) {
        this.to_use = to_use;
    }
    public JButton[] getTo_show() {
        return to_show;
    }
    public void setInfo(F_Option[] info) {
        this.info = info;
    }
    public F_Option[] getInfo() {
        return info;
    }
    public ArJtable getTo_use() {
        return to_use;
    }
    public void setTo_fuse(Field[] to_fuse) {
        this.to_fuse = to_fuse;
    }
    public Field[] getTo_fuse() {
        return to_fuse;
    }
    public void init_Jbutton(){
        this.setTo_show(new JButton[this.to_fuse.length]);
        this.setInfo(new F_Option[this.to_fuse.length]);
        for (int i = 0; i < this.to_fuse.length; i++) {
            this.to_show[i] = new JButton(this.to_fuse[i].getName());
            //System.out.println(this.to_fuse[i].getName());
            this.to_show[i].setPreferredSize(new DimensionUIResource(100, 25));
            //System.out.println("fdsffsdf");
            this.info[i] = new F_Option(this.to_use.getTo_use(), this.to_fuse[i], JFrame.DISPOSE_ON_CLOSE, false);
            this.to_show[i].addMouseListener(new Field_Opt(this.info[i]));
            this.to_show[i].addMouseListener(new Sort_(this, this.to_fuse[i]));
        }
    }
    public void launch_graph(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        Tutils_Swing.addJPanel(this);
        this.check = new JCheckBox();
        this.check.addMouseListener(new Select_all(this));
        this.add(this.check);
        Tutils_Swing.addJPanel(this);
        for (int i = 0; i < this.to_show.length; i++) {
            
            this.add(this.to_show[i]);
            Tutils_Swing.addJPanel(this);
        }
        this.doLayout();
    }
    public Ju_JBouton(ArJtable to_use){
        this.setTo_use(to_use);
        this.setTo_fuse(TUtils.getAllFields(this.to_use.getTo_use()[0]));
        System.out.println(this.to_fuse.length);
        this.init_Jbutton();
        this.launch_graph();
    }
}