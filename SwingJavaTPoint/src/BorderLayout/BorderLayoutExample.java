package BorderLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExample {

    private JFrame f;
    private Toolkit t;
    private Dimension d;
    private JButton b1, b2, b3, b4, b5;
    private static BorderLayoutExample ble;

    public void borderLayoutMethod() {
        f = new JFrame("This is title");
        t = f.getToolkit();
        d = t.getScreenSize();
        f.setBounds(d.width / 4, d.height / 4, d.width / 2, d.height / 2);

        b1 = new JButton("North");
        b2 = new JButton("South");
        b3 = new JButton("East");
        b4 = new JButton("West");
        b5 = new JButton("Center");

        f.add(b1, BorderLayout.NORTH);
        f.add(b2, BorderLayout.SOUTH);
        f.add(b3, BorderLayout.EAST);
        f.add(b4, BorderLayout.WEST);
        f.add(b5, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        ble = new BorderLayoutExample();
        ble.borderLayoutMethod();
    }
}
