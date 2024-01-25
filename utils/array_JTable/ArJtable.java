package utils.array_JTable;

import javax.swing.*;

import utils.TUtils;
import utils.class_t_file.ArClass_File;
import utils.listeners.JFrame.Exit_JFrameK;
import utils.listeners.JFrame.Exit_JFrameM;
import utils.listeners.arJtable.*;
import utils.swing.Tutils_Swing;
import utils.listeners.arJtable.Redo_;

public class ArJtable extends JPanel{
    Ju_JTextField[] content;
    Ju_JBouton topLayer;
    Object[] to_use;
    ArClass_File export;
    Object[] last_action;
    Object[] start;
    protected void setStart(Object[] start) {
        this.start = start;
    }
    public Object[] getStart() {
        return start;
    }
    public void setBackup() {
        this.last_action = to_use.clone();
    }
    public void setExport() {
        this.export = new ArClass_File(to_use, "/data");
    }
    public ArClass_File getExport() {
        return export;
    }
    public void update_() {
        for (Ju_JTextField ju_JTextField : content) {
            ju_JTextField.update_();
        }
    }
    public void export_frame(){
        JFrame export_ = new JFrame("Exported");
        export_.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        export_.setAlwaysOnTop(false);
        export_.setLocationRelativeTo(this);
        //export_.setLayout(new BoxLayout(export_, BoxLayout.Y_AXIS));
        JPanel top = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.Y_AXIS);
        
        // NOTE text 1
            Tutils_Swing.addJPanel(top);
            top.add(new JLabel("The object has been exported!"));

        // NOTE Text 2
            Tutils_Swing.addJPanel(top);
            top.add(new JLabel("Path : " + this.export.getArray_file().getPath()));
            Tutils_Swing.addJPanel(top);

        Tutils_Swing.addJPanel(top);

        // NOTE Exit Button panel
            JPanel bouPanel = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.X_AXIS);
            top.add(bouPanel);
            Tutils_Swing.addJPanel(bouPanel);

                // NOTE Bouton Panel
                JButton bo1 = Tutils_Swing.addJButton(bouPanel, "exit");
                bo1.addMouseListener(new Exit_JFrameM(export_));
                bo1.addKeyListener(new Exit_JFrameK(export_));

            Tutils_Swing.addJPanel(bouPanel);
        Tutils_Swing.addJPanel(top);
        //export_.doLayout();
        export_.add(top);
        export_.pack();
        export_.setResizable(false);
        export_.setVisible(true);
    }
    public void export_(){
        this.setExport();
        this.export_frame();
    }
    public void setContent(Ju_JTextField[] content) {
        this.content = content;
    }
    public void setTo_use(Object[] to_use) {
        this.to_use = to_use;
    }
    public void setTopLayer(Ju_JBouton topLayer) {
        this.topLayer = topLayer;
    }
    public Ju_JTextField[] getContent() {
        return content;
    }
    public Object[] getTo_use() {
        return to_use;
    }
    public Ju_JBouton getTopLayer() {
        return topLayer;
    }
    public void init_content(){
        Ju_JTextField[] contents = new Ju_JTextField[this.to_use.length];
        for (int i = 0; i < contents.length; i++) {
            contents[i] = new Ju_JTextField(to_use[i], this);
        }
        this.setContent(contents);
    }
    public void launch_graph(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel s_top = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.X_AXIS);
        // NOTE top panel
            JPanel top = new JPanel();
            top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
            Tutils_Swing.addJPanel(s_top);
            top.add(this.topLayer);
            JPanel con_tent = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.Y_AXIS);
            for (Ju_JTextField ju_JTextField : content) {
                con_tent.add(ju_JTextField);
            }
            JScrollPane scrollable = new JScrollPane(con_tent);
            top.add(scrollable);
            top.doLayout();
            s_top.add(top);
        
        // NOTE command panel
            JPanel command = Tutils_Swing.JPanelW_BoxLayout(BoxLayout.Y_AXIS);
            Tutils_Swing.addJPanel(command);

            // NOTE refresh button 
                JButton refresh = Tutils_Swing.addJButton(command, "Refresh");
                refresh.addMouseListener(new Refresh_all(this));
                Tutils_Swing.addJPanel(command);
            
            // NOTE start button 
                JButton start = Tutils_Swing.addJButton(command, "Reinitialize");
                start.addMouseListener(new Start_Ar(this));
                Tutils_Swing.addJPanel(command);

            // NOTE redo button 
                JButton redo = Tutils_Swing.addJButton(command, "Redo");
                redo.addMouseListener(new Redo_(this));
                Tutils_Swing.addJPanel(command);

            // NOTE add button 
                JButton add = Tutils_Swing.addJButton(command, "Add");
                add.addMouseListener(new Add_line(this));
                Tutils_Swing.addJPanel(command);

            // NOTE delete button 
                JButton delete = Tutils_Swing.addJButton(command, "Delete");
                delete.addMouseListener(new Delete_(this));
                Tutils_Swing.addJPanel(command);
            
            // NOTE add button 
                JButton split = Tutils_Swing.addJButton(command, "Split");
                split.addMouseListener(new Split_(this));
                Tutils_Swing.addJPanel(command);

            // NOTE export button 
                JButton export = Tutils_Swing.addJButton(command, "Export");
                export.addMouseListener(new Ar_export(this));
                Tutils_Swing.addJPanel(command);
            
            // NOTE search button 
                JButton search = Tutils_Swing.addJButton(command, "Search");
                search.addMouseListener(new Search_Ar(this));
                Tutils_Swing.addJPanel(command);
            s_top.add(command);
        Tutils_Swing.addJPanel(s_top);
        this.add(s_top);
        this.doLayout();
    }
    public void redo(){
        if(this.last_action != null){
            this.setTo_use(this.last_action);
            this.init_content();
            this.removeAll();
            this.setTopLayer(new Ju_JBouton(this));
            this.launch_graph();
        }
    }
    public void add_Intable(){
        this.setBackup();
        this.setTo_use(TUtils.addNew(this.to_use));
        this.init_content();
        this.removeAll();
        this.setTopLayer(new Ju_JBouton(this));
        this.launch_graph();
    }
    public void sortASC(String arg){
        this.setBackup();
        this.setTo_use(TUtils.sortASC(this.to_use, arg));
        this.init_content();
        this.removeAll();
        this.setTopLayer(new Ju_JBouton(this));
        this.launch_graph();
    }
    public void sortDESC(String arg){
        this.setBackup();
        this.setTo_use(TUtils.sortASC(this.to_use, arg));
        this.init_content();
        this.removeAll();
        this.setTopLayer(new Ju_JBouton(this));
        this.launch_graph();
    }
    public int getSelected_length(){
        int returns = 0;
        for (Ju_JTextField ju_JTextField : content) {
            if (ju_JTextField.getSelected() == 1) {
                returns++;
            }
        }
        return returns;
    }
    public int[] getSelected(){
        int[] returns = new int[this.getSelected_length()];
        int i = 0;
        for (int j = 0; j < this.content.length; j++) {
            if (this.content[j].getSelected() == 1) {
                returns[i] = j;
                i++;
            }
        }
        return returns;
    }
    public void select_all(){
        for (Ju_JTextField textField : content) {
            textField.setSelected(1);
            textField.getCheck().setSelected(true);
        }
    }
    public void deselect_all(){
        for (Ju_JTextField textField : content) {
            textField.setSelected(0);
            textField.getCheck().setSelected(false);
        }
    }
    public void delete(){
        this.setTo_use(TUtils.deleteN(this.to_use, this.getSelected()));
        this.init_content();
        this.removeAll();
        this.setTopLayer(new Ju_JBouton(this));
        this.launch_graph();
    }
    public void split(){
        this.setBackup();
        if(this.getSelected_length() == 2){
            this.setTo_use(TUtils.split(this.to_use, this.getSelected()[0], this.getSelected()[1]));
            this.init_content();
            this.removeAll();
            this.setTopLayer(new Ju_JBouton(this));
            this.launch_graph();
        }
    }
    public void from_start(){
        this.setBackup();
        this.setTo_use(this.start);
        this.init_content();
        this.removeAll();
        this.setTopLayer(new Ju_JBouton(this));
        this.launch_graph();
    }
    public ArJtable(Object[] to_use){
        this.setStart(to_use.clone());
        this.setTo_use(to_use);
        this.setTopLayer(new Ju_JBouton(this));
        this.init_content();
        this.launch_graph();
    }
}
