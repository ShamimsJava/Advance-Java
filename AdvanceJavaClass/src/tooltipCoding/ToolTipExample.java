package tooltipCoding;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ToolTipExample{
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JButton button = new JButton("Hello");
        button.setToolTipText("This is tooltip text.");
        f.add(button);
        f.pack();
        f.setSize(new java.awt.Dimension(418, 345));
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
