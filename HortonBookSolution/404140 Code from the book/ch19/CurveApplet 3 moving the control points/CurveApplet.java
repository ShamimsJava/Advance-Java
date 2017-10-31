import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CurveApplet extends JApplet {
  // Initialize the applet
  @Override
  public void init() {
    pane = new CurvePane();                                            // Create pane containing curves
    Container content = getContentPane();                              // Get the content pane

    // Add the pane displaying the curves to the content pane for the applet
    content.add(pane);                                                 // BorderLayout.CENTER is default position
  MouseHandler handler = new MouseHandler();                           // Create the listener
  pane.addMouseListener(handler);                                      // Monitor mouse button presses
  pane.addMouseMotionListener(handler);                                // as well as movement

  }

  // Class defining a pane on which to draw
  class CurvePane extends JComponent {
    // Constructor
    public CurvePane() {
      quadCurve = new QuadCurve2D.Double(                              // Create quadratic curve
                      startQ.x, startQ.y,                              // Segment start point
                      control.x, control.y,                            // Control point
                      endQ.x, endQ.y);                                 // Segment end point

      cubicCurve = new CubicCurve2D.Double(                            // Create cubic curve
                      startC.x, startC.y,                              // Segment start point
                      controlStart.x, controlStart.y,                  // Control pt for start
                      controlEnd.x, controlEnd.y,                      // Control point for end
                      endC.x, endC.y);                                 // Segment end point
    }

    @Override
    public void paint(Graphics g) {
      Graphics2D g2D = (Graphics2D)g;                                  // Get a 2D device context

      // Update the curves with the current control point positions
      quadCurve.ctrlx = ctrlQuad.getCenter().x;
      quadCurve.ctrly = ctrlQuad.getCenter().y;
      cubicCurve.ctrlx1 = ctrlCubic1.getCenter().x;
      cubicCurve.ctrly1 = ctrlCubic1.getCenter().y;
      cubicCurve.ctrlx2 = ctrlCubic2.getCenter().x;
      cubicCurve.ctrly2 = ctrlCubic2.getCenter().y;

      // Draw the curves
      g2D.setPaint(Color.BLUE);
      g2D.draw(quadCurve);
      g2D.draw(cubicCurve);

      // Create and draw the markers showing the control points
      g2D.setPaint(Color.red);                                         // Set the color
      ctrlQuad.draw(g2D);
      ctrlCubic1.draw(g2D);
      ctrlCubic2.draw(g2D);
      // Draw tangents from the curve end points to the control marker centers
      Line2D.Double tangent = new Line2D.Double(startQ, ctrlQuad.getCenter());
      g2D.draw(tangent);
      tangent = new Line2D.Double(endQ, ctrlQuad.getCenter());
      g2D.draw(tangent);

      tangent = new Line2D.Double(startC, ctrlCubic1.getCenter());
      g2D.draw(tangent);
      tangent = new Line2D.Double(endC, ctrlCubic2.getCenter());
      g2D.draw(tangent);
    }
  }

  // Inner class defining a control point marker
  private class Marker {
    public Marker(Point2D.Double control)  {
      center = control;                                                // Save control point as circle center

      // Create circle around control point
      circle = new Ellipse2D.Double(control.x-radius, control.y-radius,
                                    2.0*radius, 2.0*radius);
    }

      // Draw the marker
      public void draw(Graphics2D g2D) {
        g2D.draw(circle);
      }

     // Get center of marker - the control point position
      Point2D.Double getCenter() {
        return center;
    }

    // Test if a point x,y is inside the marker
    public boolean contains(double x, double y) {
      return circle.contains(x,y);
    }

    // Sets a new control point location
    public void setLocation(double x, double y) {
      center.x = x;                      // Update control point
      center.y = y;                      // coordinates
      circle.x = x-radius;               // Change circle position
      circle.y = y-radius;               // correspondingly
    }

    Ellipse2D.Double circle;                                           // Circle around control point
    Point2D.Double center;                                             // Circle center - the control point
    static final double radius = 3;                                    // Radius of circle
  }

  private class MouseHandler extends MouseInputAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
      // Check if the cursor is inside any marker
      if(ctrlQuad.contains(e.getX(), e.getY()))
        selected = ctrlQuad;
      else if(ctrlCubic1.contains(e.getX(), e.getY()))
        selected = ctrlCubic1;
      else if(ctrlCubic2.contains(e.getX(), e.getY()))
        selected = ctrlCubic2;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      selected = null;                                                 // Deselect any selected marker
    }

    @Override
    public void mouseDragged(MouseEvent e) {
      if(selected != null) {                                           // If a marker is selected
        // Set the marker to current cursor position
        selected.setLocation(e.getX(), e.getY());
        pane.repaint();                                                // Redraw pane contents
      }
    }

    private Marker selected;                                           // Stores reference to selected marker
  }

  // Points for quadratic curve
  private Point2D.Double startQ = new Point2D.Double(50, 75);          // Start point
  private Point2D.Double endQ = new Point2D.Double(150, 75);           // End point
  private Point2D.Double control = new Point2D.Double(80, 25);         // Control point

  // Points for cubic curve
  private Point2D.Double startC = new Point2D.Double(50, 150);         // Start point
  private Point2D.Double endC = new Point2D.Double(150, 150);          // End point
  private Point2D.Double controlStart = new Point2D.Double(80, 100);   // 1st cntrl point
  private Point2D.Double controlEnd = new Point2D.Double(160, 100);    // 2nd cntrl point
  private QuadCurve2D.Double quadCurve;                                // Quadratic curve
  private CubicCurve2D.Double cubicCurve;                              // Cubic curve
  private CurvePane pane = new CurvePane();                            // Pane to contain curves

   // Markers for control points
   private Marker ctrlQuad = new Marker(control);
   private Marker ctrlCubic1 = new Marker(controlStart);
   private Marker ctrlCubic2 = new Marker(controlEnd);

}
