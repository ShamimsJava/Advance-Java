package CardLayout;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CardLayoutExample implements ActionListener {

    private JFrame f;
    private Toolkit t;
    private Dimension d;
    private JButton b1, b2, b3, b4, b5, b6;
    private CardLayout cl;
    private static CardLayoutExample cle;
    private Container c;

    public void cardLayoutMethod() {
        f = new JFrame("This is title");
        c = new Container();
        f.add(c);
        t = f.getToolkit();
        d = t.getScreenSize();
        f.setBounds(d.width / 4, d.height / 4, d.width / 2, d.height / 2);

        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        b5 = new JButton("Button 5");
        b6 = new JButton("Button 6");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(b6);

        cl = new CardLayout(40, 30);
        c.setLayout(cl);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cl.next(c);
    }

    public static void main(String[] args) {
        cle = new CardLayoutExample();
        cle.cardLayoutMethod();
    }
}
