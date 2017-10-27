package CenteringWindow;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.JFrame;

public class Window3 {
    public static void main(String[] args) {
        JFrame j = new JFrame("This is title");
        Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        j.setBounds(p.x-200, p.y-75, 400, 150);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
