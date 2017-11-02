package mouseEvent;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventExample extends JFrame implements MouseListener{

    Label label;
    
    MouseEventExample(){
        addMouseListener(this);
        label = new Label("this is label");
        
        add(label);
        pack();
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        label.setText("mouseClicked");
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    label.setText("mousePressed");    
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    label.setText("mouseReleased"); 
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    label.setText("mouseEntered"); 
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    label.setText("mouseExited");
    }
    
    public static void main(String[] args) {
        new MouseEventExample();
    }
}
