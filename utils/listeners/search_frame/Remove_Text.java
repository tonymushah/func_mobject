package utils.listeners.search_frame;

import java.awt.event.*;

import javax.swing.JTextField;

public class Remove_Text implements KeyListener{
    JTextField to_use;
    public void setTo_use(JTextField to_use) {
        this.to_use = to_use;
    }
    public JTextField getTo_use() {
        return to_use;
    }
    public Remove_Text(JTextField to_use){
        this.setTo_use(to_use);
    }
    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                to_use.setText("");
                to_use.removeKeyListener(this);
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
