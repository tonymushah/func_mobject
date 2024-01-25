package utils.array_JTable;
import javax.swing.*;

public class ArrFrame extends JFrame{
    Object[] to_use;
    ArJtable arJtable;
    public void setArJtable(ArJtable arJtable) {
        this.arJtable = arJtable;
    }
    public void setTo_use(Object[] to_use) {
        this.to_use = to_use;
    }
    public Object[] getTo_use() {
        return to_use;
    }
    public ArJtable getArJtable() {
        return arJtable;
    }
    public void launch_graph(){
        this.setAlwaysOnTop(false);
        //this.setResizable(false);
        
        this.add(this.arJtable);
        this.pack();
        
    }
    public ArrFrame(Object[] to_use){
        this.setTo_use(to_use);
        this.setArJtable(new ArJtable(this.to_use));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.launch_graph();
        this.setVisible(true);
    }
    public ArrFrame(Object[] to_use, int DefaultCloseOperation, boolean Visible){
        this.setTo_use(to_use);
        this.setArJtable(new ArJtable(this.to_use));
        this.setDefaultCloseOperation(DefaultCloseOperation);
        this.launch_graph();
        this.setVisible(Visible);
    }
}
