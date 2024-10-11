
package simplenotepad;

import java.awt.Color;

public class FunctionColor {
    GUI gui;
    public FunctionColor(GUI gui){
        this.gui = gui;
    }
    public void changeColor(String color){
        switch(color){
            case "White":
                gui.window.getContentPane().setBackground(Color.WHITE);
                gui.TextArea.setBackground(Color.WHITE);
                gui.TextArea.setForeground(Color.BLACK);
                break;
            case "Black":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.TextArea.setBackground(Color.BLACK);
                gui.TextArea.setForeground(Color.WHITE);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(Color.BLUE);
                gui.TextArea.setBackground(Color.BLUE);
                gui.TextArea.setForeground(Color.WHITE);
                break;
        }
    }
    
}
