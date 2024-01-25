import javax.swing.*;

import utils.forms.*;

public class TestFrame extends JFrame{
    Forms to_fuse;
    Object to_use;
    public void addJPanel(){
        this.add(new JPanel());
    }
    public void setTo_fuse(Forms to_fuse) {
        this.to_fuse = to_fuse;
    }
    public Forms getTo_fuse() {
        return to_fuse;
    }
    public void setTo_use(Object to_use) {
        this.to_use = to_use;
        this.setTo_fuse(new Forms(to_use));
    }
    public Object getTo_use() {
        return to_use;
    }
    public void launch_graph(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setAlwaysOnTop(false);
        // NOTE JPanel top
        JPanel top = new JPanel();
        BoxLayout top_layout = new BoxLayout(top, BoxLayout.Y_AXIS);
        top.setLayout(top_layout);
        top.add(to_fuse);
        this.add(top);
        this.pack();
        this.setVisible(true);
    } 
    public TestFrame(Object to_use){
        this.setTitle(to_use.toString());
        this.setTo_use(to_use);
        this.launch_graph();
    }
}
