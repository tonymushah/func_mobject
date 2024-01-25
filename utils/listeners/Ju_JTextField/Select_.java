package utils.listeners.Ju_JTextField;

import java.awt.event.MouseEvent;

import javax.swing.event.*;

import utils.array_JTable.*;

public class Select_ implements MouseInputListener{
    Ju_JTextField to_use;
    public void setTo_use(Ju_JTextField to_use) {
        this.to_use = to_use;
    }
    public Ju_JTextField getTo_use() {
        return to_use;
    }
    public Select_(Ju_JTextField to_use){
        this.setTo_use(to_use);
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        this.to_use.select();
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
}