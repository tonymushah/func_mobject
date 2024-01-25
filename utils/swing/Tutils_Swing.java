package utils.swing;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.*;

public class Tutils_Swing {
    public static void addJPanel(JComponent target){
        target.add(new JPanel());
    }
    public static JComponent addSomething(JComponent target, JComponent toinsert){
        target.add(toinsert);
        return toinsert;
    }
    public static JPanel JPanelW_BoxLayout(int axis){
        JPanel returns = new JPanel();
        BoxLayout to_use = new BoxLayout(returns, axis);
        returns.setLayout(to_use);
        returns.doLayout();
        return returns;
    }
    public static JPanel JPanelW_Layout(JPanel target, LayoutManager lm) {
        target.setLayout(lm);
        target.doLayout();
        return target;
    }
    public static JComponent JCpnntW_Layout(JComponent target, LayoutManager lm) {
        target.setLayout(lm);
        target.doLayout();
        return target;
    }
    public static JButton addJButton(JComponent target, String text){
        JButton to_inflige = new JButton(text);
        target.add(to_inflige);
        return to_inflige;
    }
    // BUG Those addJButton with listener, the listener does'nt work
    public static JButton addJButton(JComponent target, String text, MouseInputListener listener){
        JButton to_inflige = new JButton(text);
        target.add(to_inflige);
        target.addMouseListener(listener);
        return to_inflige;
    }
    public static JButton addJButton(JComponent target, String text, KeyListener listener){
        JButton to_inflige = new JButton(text);
        target.add(to_inflige);
        target.addKeyListener(listener);
        return to_inflige;
    }
    public static JButton addJButton(JComponent target, String text, MouseInputListener Mlistener, KeyListener Klistener){
        JButton to_inflige = new JButton(text);
        target.add(to_inflige);
        target.addKeyListener(Klistener);
        target.addMouseListener(Mlistener);
        return to_inflige;
    }
    // TODO finish the message_box function
    public static void message_box(String message){

    }
    // TODO get_data in jcomponent
    public static String get_data(JComponent to_use){
        if(to_use instanceof JTextField){
            return ((JTextField) to_use).getText();
        }else if(to_use instanceof TComboBox){
            try {
                return ((TComboBox) to_use).getSelected();
            } catch (Exception e) {
                //TODO: handle exception
            }    
        }else if(to_use instanceof JComboBox){
            try {
                return (String) ((JComboBox) to_use).getSelectedItem();
            } catch (Exception e) {
                //TODO: handle exception
            }    
        }
        throw new NoClassDefFoundError("the fonction Tutils.get_data(JComponent) can't extract the data in the component " + to_use.toString());
    }
}
