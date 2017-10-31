// Main window for the Sketcher application
import javax.swing.*;

@SuppressWarnings("serial")
public class SketcherFrame extends JFrame {
  // Constructor
  public SketcherFrame(String title) {
    setTitle(title);                                                   // Set the window title
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setJMenuBar(menuBar);                                              // Add the menu bar to the window

    JMenu fileMenu = new JMenu("File");                                // Create File menu
    JMenu elementMenu = new JMenu("Elements");                         // Create Elements menu

    menuBar.add(fileMenu);                                             // Add the file menu
    menuBar.add(elementMenu);                                          // Add the element menu
  }

  private JMenuBar menuBar = new JMenuBar();                           // Window menu bar
}
