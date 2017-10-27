package Discussion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class WindowExample {

    private JFrame f;
    private Toolkit t;
    private Dimension d;

    public WindowExample() {
        winMethod();
    }
    
    public void winMethod() {
        f = new JFrame("This is title");
        t = f.getToolkit();
        d = t.getScreenSize();
        f.setBounds(d.width / 4, d.height / 4, d.width / 2, d.height / 2);
        f.getContentPane().setBackground(Color.red);
        f.setCursor(Cursor.getPredefinedCursor(12));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
       new WindowExample();
    }
}
