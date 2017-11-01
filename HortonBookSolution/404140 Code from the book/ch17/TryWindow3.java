import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TryWindow3 {
  public static void createWindow(){
    JFrame aWindow = new JFrame("This is the Window Title");
    int windowWidth = 400;                                             // Window width in pixels
    int windowHeight = 150;                                            // Window height in pixels
    aWindow.setSize(windowWidth, windowHeight);                        // Set window size
    aWindow.setLocationRelativeTo(null);                               // Center window

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