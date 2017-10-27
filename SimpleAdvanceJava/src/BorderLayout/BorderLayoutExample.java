package BorderLayout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExample {
    public static void main(String[] args) {
        JFrame j = new JFrame("Title");
        Toolkit t = j.getToolkit();
        Dimension d = t.getScreenSize();
        j.setBounds(d.width / 4, d.height / 4, // position
                d.width / 2, d.height / 2);
        
        ///////////////////////////////////////////////////////
        Container c = j.getContentPane();
        c.add(new JButton("East"), BorderLayout.EAST);
        c.add(new JButton("West"), BorderLayout.WEST);
        c.add(new JButton("North"), BorderLayout.NORTH);
        c.add(new JButton("South"), BorderLayout.SOUTH);
        c.add(new JButton("Center"), BorderLayout.CENTER);
        ///////////////////////////////////////////////////////
        
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
