package window;

import java.awt.*;
import javax.swing.*;

public class window3 {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("This is title");
        Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        jframe.setBounds(point.x-200, point.y-75, 
                        400, 150);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}
