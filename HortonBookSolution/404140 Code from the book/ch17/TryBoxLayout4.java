import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class TryBoxLayout4 {

  public static void createWindow(){
    JFrame aWindow = new JFrame("This is the Window Title");
    Toolkit theKit = aWindow.getToolkit();                             // Get the window toolkit
    Dimension wndSize = theKit.getScreenSize();                        // Get screen size

    // Set the position to screen center & size to half screen size
    aWindow.setSize(wndSize.width/2, wndSize.height/2);                // Set window size
    aWindow.setLocationRelativeTo(null);                               // Center window
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create left column of radio buttons
    Box left = Box.createVerticalBox();
    left.add(Box.createVerticalStrut(30));                             // Starting space
    ButtonGroup radioGroup = new ButtonGroup();                        // Create button group
    JRadioButton rbutton;                                              // Stores a button
    radioGroup.add(rbutton = new JRadioButton("Red"));                 // Add to group
    left.add(rbutton);                                                 // Add to Box
    left.add(Box.createVerticalStrut(30));                             // Space between
    radioGroup.add(rbutton = new JRadioButton("Green"));
    left.add(rbutton);
    left.add(Box.createVerticalStrut(30));                             // Space between
    radioGroup.add(rbutton = new JRadioButton("Blue"));
    left.add(rbutton);
    left.add(Box.createVerticalStrut(30));                             // Space between
    radioGroup.add(rbutton = new JRadioButton("Yellow"));
    left.add(rbutton);
    left.add(Box.createGlue());                                        // Glue at the end

    // Create a panel with a titled border to hold the left Box container
    JPanel leftPanel = new JPanel(new BorderLayout());
    leftPanel.setBorder(new TitledBorder(
                                   new EtchedBorder(),                 // Border to use
                                   "Line Color"));                     // Border title
    leftPanel.add(left, BorderLayout.CENTER);

    // Create right columns of checkboxes
    Box right = Box.createVerticalBox();
    right.add(Box.createVerticalStrut(30));                            // Starting space
    right.add(new JCheckBox("Dashed"));
    right.add(Box.createVerticalStrut(30));                            // Space between
    right.add(new JCheckBox("Thick"));
    right.add(Box.createVerticalStrut(30));                            // Space between
    right.add(new JCheckBox("Rounded"));
    right.add(Box.createGlue());                                       // Glue at the end

    // Create a panel with a titled border to hold the right Box container
    JPanel rightPanel = new JPanel(new BorderLayout());
    rightPanel.setBorder(new TitledBorder(
                                   new EtchedBorder(),                 // Border to use
                                   "Line Properties"));                // Border title
    rightPanel.add(right, BorderLayout.CENTER);

    // Create top row to hold left and right
    Box top = Box.createHorizontalBox();
    top.add(leftPanel);
    top.add(Box.createHorizontalStrut(5));                             // Space between vertical boxes
    top.add(rightPanel);

    // Create bottom row of buttons
    JPanel bottomPanel = new JPanel();
    bottomPanel.setBorder(new CompoundBorder(
           BorderFactory.createLineBorder(Color.black, 1),             // Outer border
           BorderFactory.createBevelBorder(BevelBorder.RAISED)));      // Inner border
    Border edge = BorderFactory.createRaisedBevelBorder();             // Button border
    JButton button;
    Dimension size = new Dimension(80,20);
    bottomPanel.add(button = new JButton("Defaults"));
    button.setBorder(edge);
    button.setPreferredSize(size);
    bottomPanel.add(button = new JButton("OK"));
    button.setBorder(edge);
    button.setPreferredSize(size);
    bottomPanel.add(button = new JButton("Cancel"));
    button.setBorder(edge);
    button.setPreferredSize(size);

    // Add top and bottom panel to content pane
    Container content = aWindow.getContentPane();                      // Get content pane
    BoxLayout box = new BoxLayout(content, BoxLayout.Y_AXIS);
                                                                       // Vertical for content pane
    content.setLayout(box);                                            // Set box layout manager
    content.add(top);
    content.add(bottomPanel);

    aWindow.pack();                                                    // Size for components
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