package GridBagLayout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutExample {

    public static void main(String[] args) {
        JFrame j = new JFrame("Title");
        Toolkit t = j.getToolkit();
        Dimension d = t.getScreenSize();
        j.setBounds(d.width / 4, d.height / 4, // position
                d.width / 2, d.height / 2);
        Container c = j.getContentPane();
        
        GridBagLayout g = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        c.setLayout(g);

        JButton b1 = new JButton("Button 1");
        g.setConstraints(b1, gc);
        c.add(b1);

        JButton b2 = new JButton("Button 2");
        g.setConstraints(b2, gc);
        c.add(b2);
       
        JButton b3 = new JButton("Button 3");
        g.setConstraints(b3, gc);
        c.add(b3);

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);

    }
}
