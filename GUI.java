
package simplenotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;  // jframe is a class from swing library //it provides base for window
import javax.swing.JMenu;   //setting menu
import javax.swing.JMenuBar;  //for menubar
import javax.swing.JMenuItem;  //for adding menu item
import javax.swing.JScrollPane; //for scroll bar
import javax.swing.JTextArea;  //for textarea
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener {
    JFrame window;  //declaration of object of jframe class
    
    //Text Area
    JTextArea TextArea;
    JScrollPane scrollBar;
    boolean WordWrapOn = false;
    //Top menu Bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    //file menu
    JMenuItem itemNew,itemOpen, itemSave, itemSaveAs, itemExit;
    //Edit menu
    JMenuItem itemUndo,itemRedo;
    //Format menu
    JMenuItem itemWrap, iFontArial,iFontTNR,iFontCSMS,iFontMSG,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24;
    JMenu menuFont,menuFontSize;
    //Color Menu
    JMenuItem iColor1,iColor2,iColor3;
    
    FunctionFile file = new FunctionFile(this);      //to access functionfile class
    FunctionFormat format = new FunctionFormat(this);
    FunctionColor color = new FunctionColor(this);
    FunctionEdit edit = new FunctionEdit(this);
    
    UndoManager um = new UndoManager();

    public static void main(String[] args) {
        new GUI();  //instance of gui class//triggers constructors
    }
    public GUI(){ //constructor
        createWindow(); //call createwindow method
        createTextArea();
        createMenuBar();
        CreateFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();

        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();
        
        window.setVisible(true); //makes the window visible
    }
    public void createWindow(){
        window = new JFrame("Notepad"); //creates new jframe
        window.setSize(800,600);  //sets the size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //ensures the program exits when window is closed
        
    }
    public void createTextArea(){
        TextArea = new JTextArea();
        
        TextArea.getDocument().addUndoableEditListener(
        new UndoableEditListener(){
            public void undoableEditHappened(UndoableEditEvent e){
                um.addEdit(e.getEdit());
            }
    });
        
        
        scrollBar = new JScrollPane(TextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollBar.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollBar);
      }
    public void createMenuBar(){   //creating the menubar
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
                                       ///adding the menu item
         menuFile = new JMenu("File");
        menuBar.add(menuFile);
        
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        
         menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        
         menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }
    public void CreateFileMenu(){
        itemNew = new JMenuItem("New");
        itemNew.addActionListener(this);
        itemNew.setActionCommand("New");
        menuFile.add(itemNew);
        
        itemOpen = new JMenuItem("Open");  //adding file menu
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("Open");
        menuFile.add(itemOpen);
        
        itemSave = new JMenuItem("Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("Save");
        menuFile.add(itemSave);
        
        itemSaveAs = new JMenuItem("Save as");
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("SaveAs");
        menuFile.add(itemSaveAs);
        
        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("Exit");
        menuFile.add(itemExit);
    }
    public void createEditMenu(){
        itemUndo = new JMenuItem("Undo");
        itemUndo.addActionListener(this);
        itemUndo.setActionCommand("Undo");
        menuEdit.add(itemUndo);
        
        itemRedo = new JMenuItem("Redo");
        itemRedo.addActionListener(this);
        itemRedo.setActionCommand("Redo");
        menuEdit.add(itemRedo);
    }
    public void createFormatMenu(){
        itemWrap = new JMenuItem("Word Wrap: off");
        itemWrap.addActionListener(this);
        itemWrap.setActionCommand("Word Wrap");
        menuFormat.add(itemWrap);
        
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);
        
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);
        
        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);
        
        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);
        
        iFontMSG = new JMenuItem("MS Gothic");
        iFontMSG.addActionListener(this);
        iFontMSG.setActionCommand("MS Gothic");
        menuFont.add(iFontMSG);
        
        
        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);
        
        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);
        
        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);
        
        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);
        
        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);
        
        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);
    }
    public void createColorMenu(){
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);
        
        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);
        
        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String command = e.getActionCommand();
       
       switch(command){
           case "New": file.newFile(); break;
           case "Open": file.open(); break;
           case "Save": file.Save(); break;
           case "SaveAs": file.SaveAs();break;
           case "Exit": file.Exit(); break;
           
           case "Undo": edit.undo();break;
           case "Redo": edit.redo();break;
           
           case "Word Wrap": format.wordWrap(); break;
           
           case "Arial": format.setFont(command); break;
           case "Comic Sans MS": format.setFont(command);break;
           case "Times New Roman": format.setFont(command);break;                                                                                                                   
           case "MS Gothic": format.setFont(command);break;
           
            case "size8": format.createFont(8); break;
            case "size12": format.createFont(12); break;
            case "size16": format.createFont(16); break;
            case "size20": format.createFont(20); break;
            case "size24": format.createFont(24); break;
            
            case "White": color.changeColor("White"); break;
            case "Black": color.changeColor("Black"); break;
            case "Blue": color.changeColor("Blue"); break;
                      
       }
    }
    
}
