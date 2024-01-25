package utils.listeners.arJtable;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import utils.array_JTable.ArJtable;

public class Ar_export implements MouseInputListener{
    ArJtable to_use;
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        to_use.export_();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    public void setTo_use(ArJtable to_use) {
        this.to_use = to_use;
    }
    public ArJtable getTo_use() {
        return to_use;
    }
    public Ar_export(ArJtable to_use){
        this.setTo_use(to_use);
    }
}
