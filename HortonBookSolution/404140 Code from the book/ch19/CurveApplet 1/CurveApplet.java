import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

@SuppressWarnings("serial")
public class CurveApplet extends JApplet {
  // Initialize the applet
  @Override
  public void init() {
    pane = new CurvePane();                                            // Create pane containing curves
    Container content = getContentPane();                              // Get the content pane

    // Add the pane displaying the curves to the content pane for the applet
    content.add(pane);                                                 // BorderLayout.CENTER is default position
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

      // Draw the curves
      g2D.setPaint(Color.BLUE);
      g2D.draw(quadCurve);
      g2D.draw(cubicCurve);
    }
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
}
