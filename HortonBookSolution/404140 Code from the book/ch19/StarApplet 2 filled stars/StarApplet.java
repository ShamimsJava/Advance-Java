import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

@SuppressWarnings("serial")
public class StarApplet extends JApplet {
  // Initialize the applet
  @Override
  public void init() {
    StarPane pane = new StarPane();                                    // Pane containing stars
    getContentPane().add(pane);                                        // BorderLayout.CENTER is default position
  }

  // Class defining a pane on which to draw
  class StarPane extends JComponent {
    @Override
    public void paint(Graphics g) {
      Graphics2D g2D = (Graphics2D)g;
      float delta = 60;                                                // Increment between stars
      float starty = 0;                                                // Starting y position

      // Draw 3 rows of 4 stars
      GeneralPath star = null;
      for(int yCount = 0 ; yCount < 3 ; yCount++) {
        starty += delta;                                               // Increment row position
        float startx = 0;                                              // Start x position in a row

        // Draw a row of 4 stars
        for(int xCount = 0 ; xCount < 4 ; xCount++) {
          star = Star.starAt(startx += delta, starty);
          g2D.setPaint(Color.GREEN);                                   // Color for fill is green
          g2D.fill(star);                                              // Fill the star
          g2D.setPaint(Color.BLUE);                                    // Drawing color blue
          g2D.draw(star);
        }
      }
    }
  }
}
