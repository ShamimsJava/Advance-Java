package example809;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class TryApplet extends JApplet {

    @Override
    public void init() {
        Container content = getContentPane();
        content.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        JButton button;
        Font[] fonts = {
            new Font("Serif", Font.ITALIC, 10),
            new Font("Dialog", Font.PLAIN, 14)
        };
        
        BevelBorder edge = new BevelBorder(BevelBorder.RAISED);
        
        for (int i = 1; i <= 6; i++) {
            content.add(button = new JButton("press "+i));
            button.setFont(fonts[i%2]);
            button.setBorder(edge);
        }
    }
}
