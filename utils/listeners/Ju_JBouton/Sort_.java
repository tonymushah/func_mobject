package utils.listeners.Ju_JBouton;

import java.awt.event.MouseEvent;
import java.lang.reflect.Field;

import javax.swing.event.*;

import utils.array_JTable.Ju_JBouton;

public class Sort_ implements MouseInputListener{
    Field to_use;
    Ju_JBouton to_use0;
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        //System.out.println(to_use.getName());
        if ((arg0.getClickCount() % 2) == 0) {
            return;
        }
        switch (arg0.getButton()) {
            case MouseEvent.BUTTON1:
                this.to_use0.getTo_use().sortASC(this.to_use.getName());
                break;
            case MouseEvent.BUTTON3:
                this.to_use0.getTo_use().sortDESC(this.to_use.getName());
                break;
            default:
                break;
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
    public void setTo_use(Field to_use) {
        this.to_use = to_use;
    }
    public void setTo_use0(Ju_JBouton to_use0) {
        this.to_use0 = to_use0;
    }
    public Field getTo_use() {
        return to_use;
    }
    public Ju_JBouton getTo_use0() {
        return to_use0;
    }
    public Sort_(Ju_JBouton to_use0, Field to_use){
        this.setTo_use(to_use);
        this.setTo_use0(to_use0);
    }
}
