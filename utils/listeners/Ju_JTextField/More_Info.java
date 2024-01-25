package utils.listeners.Ju_JTextField;

import java.awt.event.*;

import utils.array_JTable.*;

public class More_Info implements KeyListener{
    Ju_JTextField to_use;
    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_ALT:
                try {
                    this.to_use.getMother().setBackup();
                } catch (Exception e) {
                    //TODO: handle exception
                }
                this.to_use.more_info();
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
    public More_Info(Ju_JTextField to_use){
        this.setTo_use(to_use);
    }
}
