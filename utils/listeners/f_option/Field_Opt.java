package utils.listeners.f_option;

import java.awt.event.MouseEvent;

import javax.swing.event.*;

import utils.array_JTable.F_Option;

public class Field_Opt implements MouseInputListener{
    F_Option to_show;
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        if ((arg0.getClickCount() % 2) == 0) {
            to_show.setVisible(true);
        }
        switch (arg0.getButton()) {
            case MouseEvent.BUTTON2:
                to_show.setVisible(true);
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
    public void setTo_show(F_Option to_show) {
        this.to_show = to_show;
    }
    public F_Option getTo_show() {
        return to_show;
    }
    public Field_Opt(F_Option to_show){
        this.setTo_show(to_show);
    }
}
