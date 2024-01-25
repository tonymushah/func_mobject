package utils.listeners.forms;

import java.awt.event.*;
import javax.swing.event.*;

import utils.forms.Forms;

public class FormToObject implements MouseInputListener{
    Forms to_use;
    public void setTo_use(Forms to_use) {
        this.to_use = to_use;
    }
    public Forms getTo_use() {
        return to_use;
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        this.to_use.setInputToFieldSeq();
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
    public FormToObject(Forms to_use){
        this.setTo_use(to_use);
    }
}
