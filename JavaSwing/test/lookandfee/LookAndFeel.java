package lookandfee;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class LookAndFeel {
    static JFrame aWindow = new JFrame("This is the Window Title");
    
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Look and feel not set.");
        }
        JButton button = new JButton("Button");
        aWindow.setBounds(50, 100, 400, 150);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aWindow.setVisible(true);
    }
}
