package Combination;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window {
    public static void main(String[] args) {
        JFrame j = new JFrame("Title");
        Toolkit t = j.getToolkit();
        Dimension d = t.getScreenSize();
        
        j.setBounds(d.width/4, d.height/4, d.width/2, d.height/2);
        j.getContentPane().setBackground(Color.pink);
        j.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
