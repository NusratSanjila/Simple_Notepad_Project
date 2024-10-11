
package simplenotepad;

import java.awt.FileDialog;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;


public class FunctionFile {
    GUI gui;
    String fileName;
    String fileAddress;
    
    public FunctionFile(GUI gui){
        this.gui = gui;
    }
    public void newFile(){
        gui.TextArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
        
    }
    public void open(){
        FileDialog fd = new FileDialog(gui.window, "open", FileDialog.LOAD); //setting window ,windo title, and load
        fd.setVisible(true); //to make the window visible
        
        if(fd.getFile()!=null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
            
            try {
                 BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));//to read file we need address and name
                 
                 gui.TextArea.setText("");   //clears the textarea
                 
                 String line=null;
                 
                 while((line=br.readLine())!=null){
                     gui.TextArea.append(line + "\n");   //appends the text 
                 }
                 br.close();
            } catch (Exception e) {
                System.out.println("File not Opened");
            }
           
        }
    }
    public void Save(){
        if(fileName==null){
            SaveAs();
        }
        else{
        try {
            FileWriter fw =new FileWriter(fileAddress + fileName);
            fw.write(gui.TextArea.getText());
            gui.window.setTitle(fileName);
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        }
        
    }
    public void SaveAs(){
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE); //setting window ,windo title, and load
        fd.setVisible(true);
        
        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        
        try {
            FileWriter fw =new FileWriter(fileAddress + fileName);
            fw.write(gui.TextArea.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
    public void Exit(){
        System.exit(0);
    }
    
 }
        

