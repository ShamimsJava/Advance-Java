import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import static Constants.SketcherConstants.*;

@SuppressWarnings("serial")
public class SketcherView extends JComponent implements Observer {
  public SketcherView(Sketcher theApp) {
    this.theApp = theApp;
    MouseHandler handler = new MouseHandler();                          // create the mouse listener
    addMouseListener(handler);                                          // Listen for button events
    addMouseMotionListener(handler);                                    // Listen for motion events
  }

  // Method called by Observable object when it changes
  public void update(Observable o, Object rectangle) {
    if(rectangle != null) {
      repaint((java.awt.Rectangle)rectangle);
    } else {
      repaint();
    }
  }

  // Method to draw on the view
  @Override
  public void paint(Graphics g) {
    Graphics2D g2D = (Graphics2D)g;                                     // Get a 2D device context
    for(Element element: theApp.getModel()) {                           // For each element in the model
      element.draw(g2D);                                                // ...draw the element
    }
  }

  class MouseHandler extends MouseInputAdapter {
    @Override
    public void mousePressed(MouseEvent e)  {
      start = e.getPoint();                                             // Save the cursor position in start
      buttonState = e.getButton();                                      // Record which button was pressed
      if(theApp.getWindow().getElementType() == TEXT) return;

      if(buttonState == MouseEvent.BUTTON1) {
        g2D = (Graphics2D)getGraphics();                                // Get graphics context
        g2D.setXORMode(getBackground());                                // Set XOR mode
      }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      last = e.getPoint();                                              // Save cursor position
      if(theApp.getWindow().getElementType() == TEXT) return;

      if(buttonState == MouseEvent.BUTTON1) {
        if(tempElement == null) {                                       // Is there an element?
          tempElement = Element.createElement(                          // No, so create one
                                 theApp.getWindow().getElementType(),
                                 theApp.getWindow().getElementColor(),
                                 start, last);
        } else {
          tempElement.draw(g2D);                                        // Yes – draw to erase it
          tempElement.modify(start, last);                              // Now modify it
        }
        tempElement.draw(g2D);                                          // and draw it
     }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      if(theApp.getWindow().getElementType() == TEXT) {
        if(last != null) {
          start = last = null;
        }
        return;
      }

      if(e.getButton() == MouseEvent.BUTTON1) {
        buttonState = MouseEvent.NOBUTTON;                              // Reset the button state

        if(tempElement != null) {                                       // If there is an element...
          theApp.getModel().add(tempElement);                           // ...add it to the model...
          tempElement = null;                                           // ...and reset the field
        }
        if(g2D != null) {                                               // If there’s a graphics context
          g2D.dispose();                                                // ...release the resource...
          g2D = null;                                                   // ...and reset field to null
        }
        start = last = null;                                            // Remove any points
      }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      // Only if it's TEXT and button 1 was clicked
      if(theApp.getWindow().getElementType() == TEXT &&
                                         buttonState == MouseEvent.BUTTON1) {
        String text = JOptionPane.showInputDialog(
                            theApp.getWindow(),"Enter Input:",
                            "Create Text Element", JOptionPane.PLAIN_MESSAGE);

        if(text != null && !text.isEmpty()) {                           // Only if text was entered
          g2D = (Graphics2D)getGraphics();
          tempElement = new Element.Text(text,
                                         start,
                                         theApp.getWindow().getElementColor(),
                                         g2D.getFontMetrics(theApp.getWindow().getFont()));
          g2D.dispose();
          g2D = null;
          if(tempElement != null) {
            theApp.getModel().add(tempElement);
          }
        }
        tempElement = null;                                             // Reset for next element creation
        start = null;                                                   // Reset for next element
      }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
      setCursor(Cursor.getDefaultCursor());
    }

    private Point start;                                                // Stores cursor position on press
    private Point last;                                                 // Stores cursor position on drag
    private Element tempElement = null;                                 // Stores a temporary element
    private int buttonState = MouseEvent.NOBUTTON;                      // Records button state
    private Graphics2D g2D = null;                                       // Temporary graphics context
   }

  private Sketcher theApp;                                              // The application object
}
