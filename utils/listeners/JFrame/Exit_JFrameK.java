package utils.listeners.JFrame;

import java.awt.event.*;

import javax.swing.*;

public class Exit_JFrameK implements KeyListener{
    JFrame to_use;
    public void setTo_use(JFrame to_use) {
        this.to_use = to_use;
    }
    public JFrame getTo_use() {
        return to_use;
    }
    public Exit_JFrameK(JFrame to_use){
        this.setTo_use(to_use);
    }
    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                to_use.setVisible(false);
                to_use.setEnabled(false);
                break;
        
            default:
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
