package GridLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutExample {
    private JFrame f;
    private Toolkit t;
    private Dimension d;
    private JButton b;
    private GridLayout gl;
    private static GridLayoutExample gle;
    
    public void gridLayoutMethod(){
        f = new JFrame("This is title");
        t = f.getToolkit();
        d = t.getScreenSize();
        f.setBounds(d.width/4, d.height/4, d.width/2, d.height/2);
        
        for (int i = 1; i <= 9; i++) {
            b = new JButton("Button "+i);
            f.add(b);
        }
        
        gl = new GridLayout(3, 3, 20, 20);
        f.setLayout(gl);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
        gle = new GridLayoutExample();
        gle.gridLayoutMethod();
    }
}
