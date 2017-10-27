package GuiBasic;

import java.awt.Color;
import javax.swing.*;

public class Test {
    private JFrame f;
    private JPanel p;
    private JButton b;
    private JLabel l;

    public Test() {
        gui();
    }
    
    public void gui(){
        f = new JFrame();
        f.setTitle("This is title");
        f.setVisible(true);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel();
        p.setBackground(Color.pink);
        
        
        b = new JButton("Button");
        l = new JLabel("This is label");
        p.add(b);
        p.add(l);
        
        f.add(p);
    }
    public static void main(String[] args) {
        new Test();
    }
}
