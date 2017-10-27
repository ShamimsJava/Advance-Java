package FlowLayout;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayout2 extends JFrame {

    private Container c;
    private JButton b;
    private FlowLayout fl;

    public FlowLayout2() {
        flowLay();
    }

    public void flowLay() {
        setSize(1000, 200);
        c = getContentPane();
        fl = new FlowLayout();
        c.setLayout(fl);

        for (int i = 0; i < 10; i++) {
            c.add(b = new JButton("Button " + i));
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        FlowLayout2 fl = new FlowLayout2();
    }
}
