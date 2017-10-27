package ColorCursor;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window4 {
    public static void main(String[] args) {
        JFrame j = new JFrame("This is title");
        Toolkit t = j.getToolkit();
        Dimension d = t.getScreenSize();
        //System.out.println(d);
        
        j.setBounds(d.width/4, d.height/4,  // position
                d.width/2, d.height/2);
        
        j.getContentPane().setBackground(Color.pink);
        j.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
