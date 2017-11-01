import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Toolkit;
import java.awt.Dimension;

public class TryWindow2 {
  public static void createWindow(){
    JFrame aWindow = new JFrame("This is the Window Title");
    Toolkit theKit = aWindow.getToolkit();                             // Get the window toolkit
    Dimension wndSize = theKit.getScreenSize();                        // Get screen size

    // Set the position to screen center & size to half screen size
    aWindow.setBounds(wndSize.width/4, wndSize.height/4,               // Position
                      wndSize.width/2, wndSize.height/2);              // Size
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    aWindow.setVisible(true);                                          // Display the window
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createWindow();
            }
        });
  }
}