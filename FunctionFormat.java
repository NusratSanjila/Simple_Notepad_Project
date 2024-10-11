
package simplenotepad;

import java.awt.Font;

public class FunctionFormat {
    GUI gui;      //to access GUI class

    Font arial,comicSansMS,timesNewRoman,MSGothic;
    String selectedFont;
    
    public FunctionFormat(GUI gui){
        this.gui = gui;
    }
    public void wordWrap(){
        if(gui.WordWrapOn==false){
            gui.WordWrapOn=true;
            gui.TextArea.setLineWrap(true);
            gui.TextArea.setWrapStyleWord(true);
            gui.itemWrap.setText("Word Wrap: on");
            
        }
        else
        {
            gui.WordWrapOn=false;
            gui.TextArea.setLineWrap(false);
            gui.TextArea.setWrapStyleWord(false);
            gui.itemWrap.setText("Word Wrap: off");
        }
        
    }
    public void createFont(int FontSize){
        arial = new Font("Arial",Font.PLAIN,FontSize);
        comicSansMS = new Font("Comic Sans MS",Font.PLAIN,FontSize);
        timesNewRoman = new Font("Times New Roman",Font.PLAIN,FontSize);
        MSGothic = new Font("MS Gothic",Font.PLAIN,FontSize);
        
        setFont(selectedFont);
    }
    public void setFont(String font){
        selectedFont = font;
        
        switch(selectedFont){
            case "Arial":
                gui.TextArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.TextArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.TextArea.setFont(timesNewRoman);
                break;
            case "MS Gothic": 
                gui.TextArea.setFont(MSGothic);
                break;
                
        }
    }
  
    
}
