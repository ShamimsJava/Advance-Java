package WindowExample;

import javax.swing.*;

public class Window1 {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("Title");
        jframe.setBounds(50, 100, 400, 150);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}

/*
JFrame
setBounds()
setDefaultCloseOperation()
setVisible()
EXIT_ON_CLOSE
*/