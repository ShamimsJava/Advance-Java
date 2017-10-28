package page856;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JApplet;

public class Sketcher extends JApplet {
    public static void main(String[] args) {
        theApp = new Sketcher();
        theApp.init();
    }
    @Override
    public void init() {
        window = new SketchFrame("Sketcher");
        Toolkit theKit = window.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        
        window.setBounds(wndSize.width/4, wndSize.height/4, wndSize.width/2, wndSize.height/2);
        
        if(theApp != null){
            window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        }
        
        window.setVisible(true);
    }
    private static SketchFrame window;
    private static Sketcher theApp;
}
