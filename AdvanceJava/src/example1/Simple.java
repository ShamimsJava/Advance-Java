package example1;

import javax.swing.*;

public class Simple {
    JFrame f; // container
    JLabel l; // component
    JButton b; // component
    
    Simple(){
        f = new JFrame();
        l = new JLabel("Lebel");
        b = new JButton("Button");
        
        l.setBounds(10,10,50,30);
        b.setBounds(130, 100, 100, 40);
        f.add(l);
        f.add(b);
        f.setSize(400,500);
        f.setTitle("First Demo Title");
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.setDefaultCloseOperation(3);
    }
    
    public static void main(String[] args) {
        new Simple();
    }
}
