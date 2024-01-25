package utils.listeners.forms;

import java.awt.event.*;
import javax.swing.event.*;

import utils.*;
import utils.forms.Forms;

public class FormToObjectD implements MouseInputListener{
    Forms to_use;
    public void setTo_use(Forms to_fuse) {
        this.to_use = to_fuse;
    }
    public Forms getTo_use() {
        return to_use;
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        try {
            System.out.println("start");
            this.to_use.setInputToFieldSeq();
            System.out.println("OK");
            TUtils.showObject_info(to_use.getTo_use().getTo_use());
            System.out.println("ok");
        } catch (Exception e) {
            //TODO: handle exception
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
        System.out.println("start");
        this.to_use.setInputToFieldSeq();
        System.out.println("OK");
        TUtils.showObject_info(to_use.getTo_use().getTo_use());
        System.out.println("ok");
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
    public FormToObjectD(Forms to_use){
        this.setTo_use(to_use);
    }
}
