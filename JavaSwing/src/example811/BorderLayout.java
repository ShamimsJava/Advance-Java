package example811;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class BorderLayout {
    static JFrame aWindow = new JFrame("This is a Border Layout");
    private static int EAST;
    public static void main(String[] args) {
        Toolkit theKit = aWindow.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        
        aWindow.setBounds(wndSize.width/4, wndSize.height/4, wndSize.width/2, wndSize.height/2);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BorderLayout border = new BorderLayout();
        Container content = aWindow.getContentPane();
        content.setLayout((LayoutManager) border);
        EtchedBorder edge = new EtchedBorder(EtchedBorder.RAISED);
        
        JButton button;
        content.add(button = new JButton("EAST"), BorderLayout.EAST);
        button.setBorder(edge);
        
        aWindow.setVisible(true);
    }
}
