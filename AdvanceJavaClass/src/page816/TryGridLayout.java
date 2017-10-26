package page816;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;

public class TryGridLayout {
    static JFrame aWindow = new JFrame("This is title");
    public static void main(String[] args) {
        Toolkit theKit = aWindow.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        
        aWindow.setBounds(wndSize.width/4, wndSize.height/4, wndSize.width/2, wndSize.height/2);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(3,4,30,20);
        Container content = aWindow.getContentPane();
        content.setLayout(grid);
        
        EtchedBorder edge = new EtchedBorder(EtchedBorder.RAISED);
        
        JButton button = null;
        for (int i = 0; i < 12; i++) {
            content.add(button = new JButton("Grid "+i));
            button.setBorder(edge);
        }
        aWindow.pack();
        aWindow.setVisible(true);
    }
}
