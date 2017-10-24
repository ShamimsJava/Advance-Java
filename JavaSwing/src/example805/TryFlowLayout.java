package example805;

import java.awt.*;
import javax.swing.*;

public class TryFlowLayout {
    static JFrame aWindow = new JFrame("This is a Flow Layout");
    public static void main(String[] args) {
        Toolkit theKit = aWindow.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        aWindow.setBounds(wndSize.width/4, wndSize.height/4, wndSize.width/2, wndSize.height/2);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        //FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 20, 30);
        flow.setHgap(20);
        flow.setVgap(30);
        Container content = aWindow.getContentPane();
        content.setLayout(flow);
        
        
        for (int i = 0; i <= 6; i++) {
            content.add(new JButton("Press "+i));
            aWindow.setVisible(true);
            aWindow.pack();
        }
    }
}
