package utils.listeners.ArgPanel;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.*;

import utils.TCeutils;
import utils.array_JTable.ArrFrame;
import utils.forms.ArgPanel;
import utils.forms.ObjetInfo_Fra;

public class ArOpen_Field_info implements MouseInputListener{
    ArgPanel to_use;
    public void setTo_use(ArgPanel to_use) {
        this.to_use = to_use;
    }
    public ArgPanel getTo_use() {
        return to_use;
    }
    public ArOpen_Field_info(ArgPanel to_use){
        this.setTo_use(to_use);
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        TCeutils to_d = new TCeutils(to_use.getTo_ouse());

        Object[] to_show = (Object[]) to_d.getInField(to_use.getTo_use());
        new ArrFrame(to_show, JFrame.DISPOSE_ON_CLOSE, true);
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
