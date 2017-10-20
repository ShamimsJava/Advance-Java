package example1;



import javax.swing.*;

public class Simple2 extends JFrame{
    JButton b;
    Simple2(){
        b = new JButton("Button");
        b.setBounds(130,100,100,40);
        add(b);
        setSize(400,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Simple2().setVisible(true);
    }
}
