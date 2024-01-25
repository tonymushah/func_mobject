package utils.listeners.Ju_JTextField;

import java.awt.event.*;

import utils.array_JTable.Ju_JTextField;

//import

public class RefreshField implements KeyListener{
    Ju_JTextField to_refresh;
    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_F5:
                this.to_refresh.update_();
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
    public void setTo_refresh(Ju_JTextField to_refresh) {
        this.to_refresh = to_refresh;
    }
    public Ju_JTextField getTo_refresh() {
        return to_refresh;
    }
    public RefreshField(Ju_JTextField to_refresh){
        this.setTo_refresh(to_refresh);
    }
}
