package utils.array_JTable;

import java.lang.reflect.Field;

import javax.swing.*;

import utils.TUtils;
import utils.listeners.f_option.Average_;
import utils.listeners.f_option.Max_;
import utils.listeners.f_option.Min_;
import utils.listeners.f_option.Sum_;
import utils.swing.Tutils_Swing;

public class F_Option extends JFrame{
    Field to_use;
    JTextArea output;
    Object[] to_practise;
    public void setTo_use(Field to_use) {
        this.to_use = to_use;
    }
    public void setOutput(JTextArea output) {
        this.output = output;
    }
    public void setTo_practise(Object[] to_practise) {
        this.to_practise = to_practise;
    }
    public Field getTo_use() {
        return to_use;
    }
    public Object[] getTo_practise() {
        return to_practise;
    }
    public JTextArea getOutput() {
        return output;
    }
    public void setOutputSum(){
        this.output.setText(this.output.getText() + "\n" + TUtils.isum(this.to_practise, this.to_use.getName()));
        this.pack();
    }
    public void setOutputMax(){
        this.output.setText(this.output.getText() + "\n" + TUtils.imax(this.to_practise, this.to_use.getName()));
        this.pack();
    }
    public void setOutputMin(){
        this.output.setText(this.output.getText() + "\n" + TUtils.imin(this.to_practise, this.to_use.getName()));
        this.pack();
    }
    public void setOutputAver(){
        this.output.setText(this.output.getText() + "\n" + TUtils.imoyern(this.to_practise, this.to_use.getName()));
        this.pack();
    }
    public void launch_graph(){
        // NOTE top panel
            JPanel top = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.Y_AXIS);
            Tutils_Swing.addJPanel(top);
            top.add(output);
            Tutils_Swing.addJPanel(top);

            // NOTE Field option commands
                JPanel commands = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.X_AXIS);
                Tutils_Swing.addJPanel(commands);
                JButton sum = Tutils_Swing.addJButton(commands, "Sum");
                sum.addMouseListener(new Sum_(this));
                Tutils_Swing.addJPanel(commands);
                JButton average = Tutils_Swing.addJButton(commands, "Average");
                average.addMouseListener(new Average_(this));
                Tutils_Swing.addJPanel(commands);
                JButton min = Tutils_Swing.addJButton(commands, "Min");
                min.addMouseListener(new Min_(this));
                Tutils_Swing.addJPanel(commands);
                JButton max = Tutils_Swing.addJButton(commands, "Max");
                max.addMouseListener(new Max_(this));
                Tutils_Swing.addJPanel(commands);
                top.add(commands);
            
            Tutils_Swing.addJPanel(top);

            this.add(top);
        this.pack();
    }
    public F_Option(Object[] to_practise, Field to_use){
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTo_use(to_use);
        this.setTo_practise(to_practise);
        this.setOutput(new JTextArea());
        this.launch_graph();
        this.setVisible(true);
    }
    public F_Option(Object[] to_practise, Field to_use, int DefaultCloseOperation, boolean visibility){
        this.setResizable(false);
        this.setDefaultCloseOperation(DefaultCloseOperation);
        this.setTo_use(to_use);
        this.setTo_practise(to_practise);
        this.setOutput(new JTextArea());
        this.launch_graph();
        this.setVisible(visibility);
    }
}
