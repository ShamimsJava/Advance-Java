package ToolkitSizing;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window2 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Title");
        Toolkit t = f.getToolkit();
        Dimension d = t.getScreenSize();
        
        f.setBounds(d.width/4, d.height/4,  // position
                d.width/2, d.height/2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
          
    }
}
