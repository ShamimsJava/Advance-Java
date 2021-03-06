package FlowLayout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutExample {

    public static void main(String[] args) {
        JFrame j = new JFrame("Title");
        Toolkit t = j.getToolkit();
        Dimension d = t.getScreenSize();
        j.setBounds(d.width / 4, d.height / 4, // position
                d.width / 2, d.height / 2);
        
        ///////////////////////////////////////////////////
        Container c = j.getContentPane();
        for (int i = 1; i <= 6; i++) {
            c.add(new JButton("Button " + i));
        }
        
        c.setLayout(new FlowLayout());
        //////////////////////////////////////////////////
        
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
