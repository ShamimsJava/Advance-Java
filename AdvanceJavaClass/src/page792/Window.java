package page792;

import java.awt.*;
import javax.swing.*;

public class Window {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("Title");
        Toolkit toolkit = jframe.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jframe.setBounds(dimension.width/4, dimension.height/4, dimension.width/2, dimension.height/2);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jframe.getContentPane().setBackground(Color.darkGray);
        jframe.setVisible(true);
    }
}

/*
JFrame
Toolkit
Dimension
getToolkit()
getScreenSize()
setBounds()
setDefaultCloseOperation()
setCursor()
Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR)
getContentPane().setBackground(Color.darkGray)
setVisible()
*/