package window;

import javax.swing.*;

public class Window1 {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("This is title");
        jframe.setBounds(50, 100, 400, 150);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}
