package utils.listeners.arJtable;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import utils.array_JTable.ArJtable;
import utils.search.Search_Frame;

public class Search_Ar implements MouseInputListener{
    ArJtable to_use;
    public void setTo_use(ArJtable to_use) {
        this.to_use = to_use;
    }
    public ArJtable getTo_use() {
        return to_use;
    }
    public Search_Ar(ArJtable to_use){
        this.setTo_use(to_use);
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        new Search_Frame(to_use.getTo_use(), JFrame.DISPOSE_ON_CLOSE, true);
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
