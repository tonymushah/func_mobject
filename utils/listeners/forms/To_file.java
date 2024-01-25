package utils.listeners.forms;

import java.awt.event.MouseEvent;

import javax.swing.event.*;

import utils.forms.*;

public class To_file implements MouseInputListener{
    Forms to_use;
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        this.to_use.setInputToFieldSeq();
        this.to_use.setExport();
        this.to_use.export_frame();
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
    public void setTo_use(Forms to_use) {
        this.to_use = to_use;
    }
    public Forms getTo_use() {
        return to_use;
    }
    public To_file(Forms to_use){
        this.setTo_use(to_use);
    }
}
