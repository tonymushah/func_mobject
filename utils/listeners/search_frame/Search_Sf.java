package utils.listeners.search_frame;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import utils.search.Search_Frame;

public class Search_Sf implements MouseInputListener{
    Search_Frame to_use;
    public void setTo_use(Search_Frame to_use) {
        this.to_use = to_use;
    }
    public Search_Frame getTo_use() {
        return to_use;
    }
    public Search_Sf(Search_Frame to_use){
        this.setTo_use(to_use);
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        to_use.start_search();
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
