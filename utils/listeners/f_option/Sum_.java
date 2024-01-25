package utils.listeners.f_option;

import java.awt.event.MouseEvent;

import javax.swing.event.*;

import utils.array_JTable.F_Option;

public class Sum_ implements MouseInputListener{
    F_Option to_use;
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        this.to_use.setOutputSum();
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
    public void setTo_use(F_Option to_use) {
        this.to_use = to_use;
    }
    public F_Option getTo_use() {
        return to_use;
    }
    public Sum_(F_Option to_use){
        this.setTo_use(to_use);
    }
}