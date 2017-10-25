package page809;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class TryApplet2 extends JApplet {

    @Override
    public void init() {
        FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
        Container content = getContentPane();
        JButton button = new JButton();
        Font font = new Font("Serif", Font.ITALIC, 10);
        BevelBorder bevel = new BevelBorder(BevelBorder.RAISED);
        
        content.add(button);
    }
}
