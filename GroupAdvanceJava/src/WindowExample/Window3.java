package WindowExample;

import java.awt.*;
import javax.swing.*;

public class Window3 {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("Title");
        Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        
        jframe.setBounds(point.x-200, point.y-75, // position
                400, 150); // size
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}
/*
JFrame
Point
GraphicsEnvironment
getLocalGraphicsEnvironment()
getCenterPoint()
setBounds()
setDefaultCloseOperation()
setVisible()
JFrame.EXIT_ON_CLOSE
*/