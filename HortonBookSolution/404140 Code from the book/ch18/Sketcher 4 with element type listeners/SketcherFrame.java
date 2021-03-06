// Main window for the Sketcher application
import javax.swing.*;
import static java.awt.event.InputEvent.*;                             // For modifier constants
import java.awt.event.*;
import java.awt.Color;
import static java.awt.Color.*;
import static Constants.SketcherConstants.*;

@SuppressWarnings("serial")
public class SketcherFrame extends JFrame {
  // Constructor
  public SketcherFrame(String title) {
    setTitle(title);                                                   // Set the window title
    setJMenuBar(menuBar);                                              // Add the menu bar to the window
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JMenu fileMenu = new JMenu("File");                                // Create File menu
    JMenu elementMenu = new JMenu("Elements");                         // Create Elements menu
    fileMenu.setMnemonic('F');                                         // Create shortcut
    elementMenu.setMnemonic('E');                                      // Create shortcut

    // Construct the file drop-down menu
    newItem = fileMenu.add("New");                                     // Add New item
    openItem = fileMenu.add("Open");                                   // Add Open item
    closeItem = fileMenu.add("Close");                                 // Add Close item
    fileMenu.addSeparator();                                           // Add separator
    saveItem = fileMenu.add("Save");                                   // Add Save item
    saveAsItem = fileMenu.add("Save As...");                           // Add Save As item
    fileMenu.addSeparator();                                           // Add separator
    printItem = fileMenu.add("Print");                                 // Add Print item

    // Add File menu accelerators
    newItem.setAccelerator(KeyStroke.getKeyStroke('N',CTRL_DOWN_MASK ));
    openItem.setAccelerator(KeyStroke.getKeyStroke('O', CTRL_DOWN_MASK));
    saveItem.setAccelerator(KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK));
    printItem.setAccelerator(KeyStroke.getKeyStroke('P', CTRL_DOWN_MASK));

    // Construct the Element drop-down menu
    elementMenu.add(lineItem = new JRadioButtonMenuItem("Line", elementType==LINE));
    elementMenu.add(rectangleItem = new JRadioButtonMenuItem("Rectangle", elementType==RECTANGLE));
    elementMenu.add(circleItem = new JRadioButtonMenuItem("Circle", elementType==CIRCLE));
    elementMenu.add(curveItem = new JRadioButtonMenuItem("Curve", elementType==CURVE));
    ButtonGroup types = new ButtonGroup();
    types.add(lineItem);
    types.add(rectangleItem);
    types.add(circleItem);
    types.add(curveItem);

    // Add element type accelerators
    lineItem.setAccelerator(KeyStroke.getKeyStroke('L', CTRL_DOWN_MASK));
    rectangleItem.setAccelerator(KeyStroke.getKeyStroke('E', CTRL_DOWN_MASK));
    circleItem.setAccelerator(KeyStroke.getKeyStroke('I', CTRL_DOWN_MASK));
    curveItem.setAccelerator(KeyStroke.getKeyStroke('V', CTRL_DOWN_MASK));

    elementMenu.addSeparator();
    JMenu colorMenu = new JMenu("Color");                              // Color submenu
    elementMenu.add(colorMenu);                                        // Add the submenu
    colorMenu.add(redItem = new JCheckBoxMenuItem("Red", elementColor.equals(RED)));
    colorMenu.add(yellowItem = new JCheckBoxMenuItem("Yellow", elementColor.equals(YELLOW)));
    colorMenu.add(greenItem = new JCheckBoxMenuItem("Green", elementColor.equals(GREEN)));
    colorMenu.add(blueItem = new JCheckBoxMenuItem("Blue", elementColor.equals(BLUE)));

    // Add element color accelerators
    redItem.setAccelerator(KeyStroke.getKeyStroke('R', CTRL_DOWN_MASK));
    yellowItem.setAccelerator(KeyStroke.getKeyStroke('Y', CTRL_DOWN_MASK));
    greenItem.setAccelerator(KeyStroke.getKeyStroke('G', CTRL_DOWN_MASK));
    blueItem.setAccelerator(KeyStroke.getKeyStroke('B', CTRL_DOWN_MASK));

    // Add type menu item listeners
    lineItem.addActionListener(new TypeListener(LINE));
    rectangleItem.addActionListener(new TypeListener(RECTANGLE));
    circleItem.addActionListener(new TypeListener(CIRCLE));
    curveItem.addActionListener(new TypeListener(CURVE));

    menuBar.add(fileMenu);                                             // Add the file menu
    menuBar.add(elementMenu);                                          // Add the element menu
  }

  // Handles element type menu items
  class TypeListener implements ActionListener {
    // Constructor
    TypeListener(int type) {
      this.type = type;
    }

    // Sets the element type
    public void actionPerformed(ActionEvent e) {
      elementType = type;
    }

    private int type;                                                  // Store the type for the menu
  }

  private JMenuBar menuBar = new JMenuBar();                           // Window menu bar

  // File menu items
  private JMenuItem newItem,  openItem,   closeItem,
                    saveItem, saveAsItem, printItem;

  // Element menu items
  private JRadioButtonMenuItem lineItem,  rectangleItem, circleItem,   // Types
                               curveItem, textItem;
  private JCheckBoxMenuItem    redItem,   yellowItem,                  // Colors
                               greenItem, blueItem ;
  private Color elementColor = DEFAULT_ELEMENT_COLOR;                  // Current element color
  private int elementType = DEFAULT_ELEMENT_TYPE;                      // Current element type
}
