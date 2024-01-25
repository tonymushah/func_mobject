package utils.forms;

import javax.swing.*;

public class ObjetInfo_Fra extends JFrame{
    Forms to_show;
    Object to_use;
    public void setTo_show() {
        this.to_show = new Forms(to_use);
    }
    public void setTo_use(Object to_use) {
        this.to_use = to_use;
        this.setTo_show();
    }
    public Forms getTo_show() {
        return to_show;
    }
    public Object getTo_use() {
        return to_use;
    }
    public void update_(){
        this.to_show.udpateAllArgs();
    }
    public void launch_graph(){
        this.setResizable(false);
        this.setAlwaysOnTop(false);
        
        // NOTE JPanel top
            JPanel top = new JPanel();
            BoxLayout top_layout = new BoxLayout(top, BoxLayout.Y_AXIS);
            top.setLayout(top_layout);
            top.add(to_show);

        this.add(top);
        this.pack();
    }
    public ObjetInfo_Fra(Object to_use){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTo_use(to_use);
        this.launch_graph();
        this.setVisible(true);
    }
    public ObjetInfo_Fra(Object to_use, int DefaultCloseOperation){
        this.setDefaultCloseOperation(DefaultCloseOperation);
        this.setTo_use(to_use);
        this.launch_graph();
        //this.setVisible(true);
    }
    public ObjetInfo_Fra(Object to_use, int DefaultCloseOperation, boolean Visible){
        this.setDefaultCloseOperation(DefaultCloseOperation);
        this.setTo_use(to_use);
        this.launch_graph();
        this.setVisible(Visible);
    }
}
