package FlowLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutExample {

    private JFrame f;
    private Toolkit t;
    private Dimension d;
    private JButton b1, b2, b3, b4, b5, b6;
    private FlowLayout fl;
    private static FlowLayoutExample fle;

    public void flowLayoutMethod() {
        f = new JFrame("This is title");
        t = f.getToolkit();
        d = t.getScreenSize();
        f.setBounds(d.width / 4, d.height / 4, d.width / 2, d.height / 2);

        b1 = new JButton("Button 1");
        b2 = new JButton("Button 2");
        b3 = new JButton("Button 3");
        b4 = new JButton("Button 4");
        b5 = new JButton("Button 5");
        b6 = new JButton("Button 6");

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);

        fl = new FlowLayout(FlowLayout.CENTER);
        f.setLayout(fl);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        fle = new FlowLayoutExample();
        fle.flowLayoutMethod();
    }
}
