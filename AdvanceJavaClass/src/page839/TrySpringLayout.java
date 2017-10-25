package page839;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class TrySpringLayout {
    static JFrame aWindow = new JFrame("This is title"); 
    public static void main(String[] args) {
        Toolkit theKit = aWindow.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        aWindow.setBounds(wndSize.width/6, wndSize.height/6, 2*wndSize.width/3, 2*wndSize.height/3);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SpringLayout layout = new SpringLayout();
        Container content = aWindow.getContentPane();
        content.setLayout(layout);
        
        JButton[] buttons = new JButton[6];
        SpringLayout.Constraints constr = null;
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton("Press "+(i+1));
            content.add(buttons[i]);
        }
        
        Spring xSpring = Spring.constant(5, 15, 25);
        Spring ySpring = Spring.constant(10, 30, 50);
        
        constr = layout.getConstraints(buttons[0]);
        constr.setX(xSpring);
        constr.setY(ySpring);
        
        for (int i = 1; i < buttons.length; i++) {
            constr = layout.getConstraints(buttons[i]);
            layout.putConstraint(SpringLayout.WEST, buttons[i], xSpring, SpringLayout.EAST, buttons[i-1]);
            layout.putConstraint(SpringLayout.NORTH, buttons[i], ySpring, SpringLayout.SOUTH, buttons[i-1]);
        }
        aWindow.setVisible(true);
    }
}
