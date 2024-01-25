/*
    TODO Adding the path in the export fen
*/
package utils.forms;

import utils.*;
import utils.TExpections.NoLengthMatchException;
import utils.class_t_file.*;
import utils.listeners.JFrame.Exit_JFrameK;
import utils.listeners.JFrame.Exit_JFrameM;
import utils.listeners.forms.FormToObjectD;
import utils.listeners.forms.To_file;
import utils.swing.Tutils_Swing;

import javax.swing.*;

public class Forms extends JPanel{
    TCeutils to_use;
    ArgPanel[] argPanels;
    Class_File export;
    JButton action;
    public int getArgPanelIndexbyName(String name) throws NoSuchFieldError {
        for (int i = 0; i < argPanels.length; i++) {
            if (this.argPanels[i].getTo_use().getName().compareTo(name) == 0) {
                return i;
            }
        }
        throw new NoSuchFieldError("The form " + this.toString() + " don't have argPanel with field named " + name);
    }
    public ArgPanel getArgPanelbyName(String name) throws NoSuchFieldError {
        return this.argPanels[this.getArgPanelIndexbyName(name)];
    }
    public void splitArgPanelPosition(String arg0, String arg1){
        int i_arg0 = 0;
        int i_arg1 = 0;
        try {
            i_arg0 = this.getArgPanelIndexbyName(arg0);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } 
        try {
            i_arg1 = this.getArgPanelIndexbyName(arg1);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } 
        try {
            this.argPanels = (ArgPanel[]) TUtils.split(this.argPanels, i_arg0, i_arg1);
            this.removeAll();
            this.launch_graph();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    public void moveOntop(String arg0){
        int i_arg0 = 0;
        int i_arg1 = 0;
        try {
            i_arg0 = this.getArgPanelIndexbyName(arg0);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } 
        try {
            this.argPanels = (ArgPanel[]) TUtils.split(this.argPanels, i_arg1, i_arg0);
            this.removeAll();
            this.launch_graph();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    public void moveOnBottom(String arg0){
        int i_arg0 = 0;
        int i_arg1 = this.argPanels.length - 1;
        try {
            i_arg0 = this.getArgPanelIndexbyName(arg0);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        } 
        try {
            this.argPanels = (ArgPanel[]) TUtils.split(this.argPanels, i_arg1, i_arg0);
            this.removeAll();
            this.launch_graph();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    public JButton getAction() {
        return action;
    }
    public void addJPanel(){
        this.add(new JPanel());
    }
    public TCeutils getTo_use() {
        return to_use;
    }
    public void setTo_use(TCeutils to_use) {
        this.to_use = to_use;
    }
    public ArgPanel[] getArgPanels() {
        return argPanels;
    }
    public void setExport() {
        this.export = new Class_File(this.to_use.getTo_use(), "data/");
    }
    public Class_File getExport() {
        return export;
    }
    public void export_frame(){
        JFrame export_ = new JFrame("Exported");
        export_.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        export_.setAlwaysOnTop(false);
        export_.setLocationRelativeTo(this);
        //export_.setLayout(new BoxLayout(export_, BoxLayout.Y_AXIS));
        JPanel top = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.Y_AXIS);
        export_.add(top);
        // NOTE text 1
            Tutils_Swing.addJPanel(top);
            top.add(new JLabel("The object has been exported!"));

        // NOTE Text 2
            Tutils_Swing.addJPanel(top);
            top.add(new JLabel("Path : " + this.export.getFishing().getPath()));
            Tutils_Swing.addJPanel(top);

        Tutils_Swing.addJPanel(top);

        // NOTE Exit Button panel
            JPanel bouPanel = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.X_AXIS);
            top.add(bouPanel);
            Tutils_Swing.addJPanel(bouPanel);

                // NOTE Bouton Panel
                JButton bo1 = Tutils_Swing.addJButton(bouPanel, "exit");
                bo1.addMouseListener(new Exit_JFrameM(export_));
                bo1.addKeyListener(new Exit_JFrameK(export_));

            Tutils_Swing.addJPanel(bouPanel);
        Tutils_Swing.addJPanel(top);
        //export_.doLayout();
        export_.pack();
        export_.setResizable(false);
        export_.setVisible(true);
    }
    public void addArgPanels() {
        for (ArgPanel argPanel : argPanels) {
            this.add(argPanel);
            this.addJPanel();
        }
    }
    public int[] change_string_to_int_order(String[] order) throws NoLengthMatchException{
        if(order.length == this.to_use.getFieldslength()){
            int[] returns = new int[order.length];
            for (int i = 0; i < order.length; i++) {
                try {
                    returns[i] = this.to_use.getFieldIndex(order[i]);
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
        throw new NoLengthMatchException("Can't use this string array");    
    }
    
    public void addArgPanels(JComponent inert) {
        for (ArgPanel argPanel : argPanels) {
            this.add(argPanel);
            this.add(inert);
        }
    }
    public void setArgPanels() {
        ArgPanel[] panels = new ArgPanel[this.to_use.getFieldslength()];
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new ArgPanel(this.to_use.getFields()[i], this.to_use.getTo_use());
        }
        this.argPanels = panels;
    }
    public void setArgPanels(String[] order) {
        ArgPanel[] panels = new ArgPanel[this.to_use.getFieldslength()];
        try {
            int[] indexOrder = this.change_string_to_int_order(order);
            int op = 0;
            for (int i : indexOrder) {
                panels[op] = new ArgPanel(this.to_use.getFields()[i], this.to_use.getTo_use());
                op++;
            }
        } catch (NoLengthMatchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            for (int i = 0; i < panels.length; i++) {
                panels[i] = new ArgPanel(this.to_use.getFields()[i], this.to_use.getTo_use());
            }
            
        }
        this.argPanels = panels;
    }
    public void setAllInputSize(int width, int height){
        for (ArgPanel argPanel : argPanels) {
            argPanel.setInputSize(width, height);
        }
    }
    public void udpateAllArgs(){
        for (ArgPanel argPanel : argPanels) {
            argPanel.udpateInField();
        }
    }
    public void setAll_input_toArg(){
        for (ArgPanel argPanel : argPanels) {
            argPanel.setInputToField();
        }
    }
    public void setInputToFieldSeq(){
        this.setAll_input_toArg();
        this.udpateAllArgs();
    }
    public void change_argPanelInput(String name, JComponent idnput){
        ArgPanel dcc = this.getArgPanelbyName(name);
        dcc.setInput(idnput);
        dcc.removeAll();
        dcc.launch_graph();
    }
    public void hide_argPanel(String name){
        ArgPanel dcc = this.getArgPanelbyName(name);
        dcc.removeAll();
    }
    public void show_argPanel(String name){
        ArgPanel dcc = this.getArgPanelbyName(name);
        dcc = new ArgPanel(to_use.getFields()[to_use.getFieldIndex(name)], this.to_use.getTo_use());
    }
    public void setVisible(String name, boolean Visible){
        if (Visible) {
            this.show_argPanel(name);
        } else {
            this.hide_argPanel(name);
        }
    }
    public void change_argPanelLtext(String name, String text){
        ArgPanel to_d = this.getArgPanelbyName(name);
        to_d.setArgLabelText(text);
    }
    public void launch_graph(){
        // NOTE Boxlaout : y_axis
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.addJPanel();
        this.addArgPanels();
        
        // NOTE bouton panel
        JPanel bouton = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.X_AXIS);
        Tutils_Swing.addJPanel(bouton);
        JButton bo1 = Tutils_Swing.addJButton(bouton, "To class");
        bo1.addMouseListener(new FormToObjectD(this));
        Tutils_Swing.addJPanel(bouton);
        JButton bo2 = Tutils_Swing.addJButton(bouton, "Export To file");
        bo2.addMouseListener(new To_file(this));
        Tutils_Swing.addJPanel(bouton);
        this.add(bouton);
        this.addJPanel();
    }
    public Forms(Object to_use){
        this.setTo_use(new TCeutils(to_use));
        this.setArgPanels();
        this.setAllInputSize(100, 15);
        this.launch_graph();
    }
    public Forms(TCeutils to_use){
        this.setTo_use(to_use);
        this.setArgPanels();
        this.launch_graph();
    }
}
