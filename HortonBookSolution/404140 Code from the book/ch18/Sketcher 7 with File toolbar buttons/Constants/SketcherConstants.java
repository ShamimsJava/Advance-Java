// Defines application wide constants
package Constants;
import java.awt.Color;
import javax.swing.*;

public class SketcherConstants {
  // Path for images
  public final static String imagePath = "D:/Sketcher/Images/";

  // Toolbar icons
  public final static Icon NEW24 = new ImageIcon(imagePath + "New24.gif");
  public final static Icon OPEN24 = new ImageIcon(imagePath + "Open24.gif");
  public final static Icon SAVE24 = new ImageIcon(imagePath + "Save24.gif");
  public final static Icon SAVEAS24 = new ImageIcon(imagePath + "SaveAs24.gif");
  public final static Icon PRINT24 = new ImageIcon(imagePath + "Print24.gif");

  // Element type definitions
  public final static int LINE      = 101;
  public final static int RECTANGLE = 102;
  public final static int CIRCLE    = 103;
  public final static int CURVE     = 104;

  // Initial conditions
  public final static int DEFAULT_ELEMENT_TYPE = LINE;
  public final static Color DEFAULT_ELEMENT_COLOR = Color.BLUE;
}
