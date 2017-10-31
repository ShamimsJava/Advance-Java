import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class TryGridBagLayout4 {

  public static void createWindow(){
    JFrame aWindow = new JFrame("This is the Window Title");
    Toolkit theKit = aWindow.getToolkit();                             // Get the window toolkit
    Dimension wndSize = theKit.getScreenSize();                        // Get screen size

    // Set the position to screen center & size to half screen size
    aWindow.setSize(wndSize.width/2, wndSize.height/2);                // Set window size
    aWindow.setLocationRelativeTo(null);                               // Center window
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    GridBagLayout gridbag = new GridBagLayout();                       // Create a layout manager
    GridBagConstraints constraints = new GridBagConstraints();
    aWindow.getContentPane().setLayout(gridbag);                       // Set the container layout mgr

    // Set constraints and add first button
    constraints.weightx = constraints.weighty = 10.0;
    constraints.fill = GridBagConstraints.BOTH;                        // Fill the space
    addButton(" Press ", constraints, gridbag, aWindow);               // Add the button

    // Set constraints and add second button
    constraints.weightx = 5.0;                                         // Weight half of first
    constraints.insets = new java.awt.Insets(10, 30, 10, 20);          // Left 30 & right 20
    constraints.gridwidth = GridBagConstraints.RELATIVE;               // Rest of the row
    constraints.gridheight = 2;                                        // Height 2x "Press"
    addButton("GO", constraints, gridbag, aWindow);                    // Create and add button

    // Set constraints and add third button
    constraints.insets = new java.awt.Insets(0,0,0,0);                 // No insets
    constraints.gridx = 0;                                             // Begin new row
    constraints.gridwidth = 1;                                         // Width as "Press"
    constraints.gridheight = 1;                                        // Height as "Press"
    addButton("Push", constraints, gridbag, aWindow);                  // Add button to content pane

    aWindow.setVisible(true);                                          // Display the window
  }

  static void addButton(String label,
                        GridBagConstraints constraints,
                        GridBagLayout layout,
                        JFrame window) {
    // Create a Border object using a BorderFactory method
    Border edge = BorderFactory.createRaisedBevelBorder();

    JButton button = new JButton(label);                               // Create a button
    button.setBorder(edge);                                            // Add its border
    layout.setConstraints(button, constraints);                        // Set the constraints
    window.getContentPane().add(button);                               // Add button to content pane
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createWindow();
            }
        });
  }
}