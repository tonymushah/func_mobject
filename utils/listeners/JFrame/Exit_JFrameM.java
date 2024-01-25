package utils.listeners.JFrame;

import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

public class Exit_JFrameM implements MouseInputListener{
    JFrame to_use;
    public void setTo_use(JFrame to_use) {
        this.to_use = to_use;
    }
    public JFrame getTo_use() {
        return to_use;
    }
    public Exit_JFrameM(JFrame to_use){
        this.setTo_use(to_use);
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        to_use.setVisible(false);
        to_use.setEnabled(false);
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
