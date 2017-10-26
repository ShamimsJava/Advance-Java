package page844;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Sketcher {
    public static void main(String[] args) {
        window = new SketchFrame("Sketcher");
        Toolkit theKit = window.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        window.setBounds(wndSize.width/4, wndSize.height/4,
                wndSize.width/2, wndSize.height/2);
        window.setVisible(true);
    }
    private static SketchFrame window;
}
