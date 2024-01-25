package utils.search;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import utils.TUtils;
import utils.array_JTable.ArrFrame;
import utils.listeners.search_frame.Remove_Text;
import utils.listeners.search_frame.Search_Sf;
import utils.swing.Tutils_Swing;

public class Search_Frame extends JFrame{
    Object[] to_use;
    JTextField input;
    ArrFrame result;
    public void setTo_use(Object[] to_use) {
        this.to_use = to_use;
    }
    public void setInput(JTextField input) {
        this.input = input;
    }
    public void setResult(ArrFrame result) {
        this.result = result;
    }
    public Object[] getTo_use() {
        return to_use;
    }
    public JTextField getInput() {
        return input;
    }
    public ArrFrame getResult() {
        return result;
    }
    public void start_search(){
        this.setVisible(false);
        try {
            new ArrFrame(TUtils.search(to_use, input.getText()));
        } catch (Exception e) {
            //TODO: handle exception
            this.input.setText(e.getMessage());
            this.input.addKeyListener(new Remove_Text(this.input));
            this.setVisible(true);
        }
    }
    public void launch_graph(){
        this.setResizable(false);
        // NOTE Top panel
            JPanel top = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.Y_AXIS);
            Tutils_Swing.addJPanel(top);
            top.add(new JLabel("Search in " + this.to_use.toString()));
            Tutils_Swing.addJPanel(top);
                // NOTE simple field and button
                    JPanel fi_bu = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.X_AXIS);
                    Tutils_Swing.addJPanel(fi_bu);
                    fi_bu.add(this.input);
                    Tutils_Swing.addJPanel(fi_bu);
                    JButton to_u = Tutils_Swing.addJButton(fi_bu, "Search");
                    to_u.addMouseListener(new Search_Sf(this));
                    Tutils_Swing.addJPanel(fi_bu);

                top.add(fi_bu);
            Tutils_Swing.addJPanel(top);
            this.add(top);
        this.pack();
    }
    public Search_Frame(Object[] to_use){
        this.setTo_use(to_use);
        this.setInput(new JTextField());
        this.input.setPreferredSize(new DimensionUIResource(250, 15));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.launch_graph();
        this.setVisible(true);
    }
    public Search_Frame(Object[] to_use, int DefaultCloseOperation, boolean Visible){
        this.setTo_use(to_use);
        this.setInput(new JTextField());
        this.input.setPreferredSize(new DimensionUIResource(100, 15));
        this.setDefaultCloseOperation(DefaultCloseOperation);
        this.launch_graph();
        this.setVisible(Visible);
    }
}
