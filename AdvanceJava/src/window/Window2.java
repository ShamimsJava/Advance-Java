package window;

import java.awt.*;
import javax.swing.*;

public class Window2 {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("This is title");
        Toolkit toolkit = jframe.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        
        jframe.setBounds(dimension.width/4, dimension.height/4, // position
                        dimension.width/2, dimension.height/2); // size
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}
