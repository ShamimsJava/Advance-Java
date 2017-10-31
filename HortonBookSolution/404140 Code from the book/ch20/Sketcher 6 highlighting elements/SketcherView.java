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
      if(e.isPopupTrigger()) {
        theApp.getWindow().getPopup().show((Component)e.getSource(), start.x, start.y);
        start = null;
        buttonState = MouseEvent.NOBUTTON;
        return;
      }

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
      if(e.isPopupTrigger()) {
        if(last != null) {                                              // If mouse was dragged
          start = last;                                                 // show popup at last cursor position
        }
        theApp.getWindow().getPopup().show((Component)e.getSource(), start.x, start.y);
        start = last = null;
        return;
      }

      // Check for TEXT being the element type
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

        if(text != null && !text.isEmpty()) {                // Only if text was entered
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

    // Handle mouse move events
    @Override
    public void mouseMoved(MouseEvent e) {
      Point cursor = e.getPoint();                                      // Get current cursor position

      for(Element element : theApp.getModel())  {                       // Go through the list...
        if(element.getBounds().contains(cursor)) {                      // ....under the cursor
          if(element==highlightElement) {                               // If it's already highlighted
            return;                                                     // we are done
          }

          // Un-highlight any existing highlighted element
          if(highlightElement!= null) {                                 // If an element is highlighted
            highlightElement.setHighlighted(false);                     // un-highlight it and
            repaint(highlightElement.getBounds());                      //... redraw it
          }

          element.setHighlighted(true);                                 // Set highlight for new element
          highlightElement = element;                                   // Store new highlighted element
            repaint(highlightElement.getBounds());
          return;
        }
      }

      // Here there is no element under the cursor so...
      if(highlightElement!=null)   {                                    // If an element is highlighted...
        highlightElement.setHighlighted(false);                         // ...turn off highlighting...
        repaint(highlightElement.getBounds());                          // ... and redraw the element
        highlightElement = null;                                        // No element highlighted
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
    private Graphics2D g2D = null;                                      // Temporary graphics context
   }

  private Sketcher theApp;                                              // The application object
  private Element highlightElement;                                     // Highlighted element
}
