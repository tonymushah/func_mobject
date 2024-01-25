package utils.listeners.Ju_JBouton;

import java.awt.event.MouseEvent;

import javax.swing.event.*;

import utils.array_JTable.Ju_JBouton;

public class Select_all implements MouseInputListener{
    Ju_JBouton to_use;
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        if (!to_use.getCheck().isSelected()) {
            to_use.getTo_use().deselect_all();
        } else {
            to_use.getTo_use().select_all();
        }
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
    public void setTo_use(Ju_JBouton to_use) {
        this.to_use = to_use;
    }
    public Ju_JBouton getTo_use() {
        return to_use;
    }
    public Select_all(Ju_JBouton to_use){
        this.setTo_use(to_use);
    }
}
