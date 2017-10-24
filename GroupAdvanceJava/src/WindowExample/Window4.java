package WindowExample;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.*;

public class Window4 {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setTitle("This is title.");
        jframe.setLocationRelativeTo(null);
        jframe.setSize(200, 150);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jframe.getContentPane().setBackground(Color.LIGHT_GRAY);
        jframe.setVisible(true);
    }
}
