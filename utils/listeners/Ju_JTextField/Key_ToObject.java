package utils.listeners.Ju_JTextField;

import java.awt.event.*;

import utils.array_JTable.*;

public class Key_ToObject implements KeyListener{
    Ju_JTextField to_use;
    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                this.to_use.setInObjectSeq();
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
    
    public void setTo_use(Ju_JTextField to_use) {
        this.to_use = to_use;
    }
    public Ju_JTextField getTo_use() {
        return to_use;
    }
    public Key_ToObject(Ju_JTextField to_use){
        this.setTo_use(to_use);
    }
}
