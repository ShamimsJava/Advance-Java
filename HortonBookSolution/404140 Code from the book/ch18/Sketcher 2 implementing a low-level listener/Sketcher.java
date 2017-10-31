// Sketching application
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sketcher implements WindowListener {
  public static void main(String[] args) {
     theApp = new Sketcher();                                          // Create the application object
   SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              theApp.createGUI();                                      // Call GUI creator
            }
        });
  }

  // Method to create the application GUI
  private void createGUI() {
    window = new SketcherFrame("Sketcher");                            // Create the app window
    Toolkit theKit = window.getToolkit();                              // Get the window toolkit
    Dimension wndSize = theKit.getScreenSize();                        // Get screen size

    // Set the position to screen center & size to half screen size
    window.setSize(wndSize.width/2, wndSize.height/2);                 // Set window size
    window.setLocationRelativeTo(null);                                // Center window
    window.addWindowListener(this);                                    // theApp as window listener
    window.setVisible(true);
  }

  // Handler for window closing event
  public void windowClosing(WindowEvent e) {
    window.dispose();                                                  // Release the window resources
    System.exit(0);                                                    // End the application
  }

  // Listener interface methods you must implement – but don’t need
  public void windowOpened(WindowEvent e) {}
  public void windowClosed(WindowEvent e) {}
  public void windowIconified(WindowEvent e) {}
  public void windowDeiconified(WindowEvent e) {}
  public void windowActivated(WindowEvent e) {}
  public void windowDeactivated(WindowEvent e) {}

  private SketcherFrame window;                                        // The application window
  private static Sketcher theApp;                                      // The application object
}