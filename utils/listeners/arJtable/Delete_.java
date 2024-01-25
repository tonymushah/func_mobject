package utils.listeners.arJtable;

import java.awt.event.MouseEvent;

import javax.swing.event.*;

import utils.array_JTable.ArJtable;

public class Delete_ implements MouseInputListener{
    ArJtable to_use;
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        to_use.delete();
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
    public ArJtable getTo_use() {
        return to_use;
    }
    public void setTo_use(ArJtable to_use) {
        this.to_use = to_use;
    }
    public Delete_(ArJtable to_use){
        this.setTo_use(to_use);
    }
}
