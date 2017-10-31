import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

public class TryWindow {
  public static void createWindow(){
    JFrame aWindow = new JFrame("This is the Window Title");
    int windowWidth = 400;                                             // Window width in pixels
    int windowHeight = 150;                                            // Window height in pixels
    aWindow.setBounds(50, 100,                                         // Set position
                      windowWidth, windowHeight);                      // and size
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    aWindow.setVisible(true);                                          // Display the window
  }

  public static void main(String[] args) {

    // List look-and-feel class names
    UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
    for(UIManager.LookAndFeelInfo look : looks) {
      System.out.println(look.getClassName());
    }

    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createWindow();
            }
        });
  }
}
