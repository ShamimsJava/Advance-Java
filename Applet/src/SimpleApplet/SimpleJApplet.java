package SimpleApplet;

import java.applet.Applet;
import java.awt.Graphics;

public class SimpleJApplet extends Applet {

    @Override
    public void init() {
        
    }
    
    @Override
    public void paint(Graphics g){
        g.drawString("Welcome", 150, 150);
    }

    // TODO overwrite start(), stop() and destroy() methods
}
