package SimpleApplet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class GraphicsApplet2 extends Applet{
    @Override
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.drawString("Bangladesh", 50, 50);
        g.drawLine(55, 200, 1, 200);
    }
}
