package page809;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class TryApplet extends JApplet {

    @Override
    public void init() {
        FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
        Container content = getContentPane();
        content.setLayout(flow);
        
        JButton button;
        Font[] fonts = {
            new Font("Serif", Font.ITALIC, 10),
            new Font("Dialog", Font.PLAIN, 14)
        };
        
        BevelBorder edge = new BevelBorder(BevelBorder.RAISED);
        
        for (int i = 1; i <= 6; i++) {
            content.add(button = new JButton("Button "+i));
            button.setFont(fonts[i%2]);
            button.setBorder(edge);
        }
    }
}
