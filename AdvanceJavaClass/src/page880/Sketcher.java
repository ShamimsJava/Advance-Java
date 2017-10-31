package page880;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.SwingUtilities;

public class Sketcher{

    public static void main(String[] args) {
        theApp = new Sketcher();
        SwingUtilities.invokeLater(
                new Runnable() {
            @Override
            public void run() {
                theApp.creatGUI();
            }

        }
        );
    }

    private void creatGUI() {
        window = new SketchFrame("Sketcher");
        Toolkit theKit = window.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        window.setBounds(wndSize.width / 4, wndSize.height / 4, wndSize.width / 2, wndSize.height / 2);
        window.addWindowListener(new WindowHandler());
        window.setVisible(true);
    }
    
    class WindowHandler extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            window.dispose();
            System.exit(0);
        }
    }
    
    private SketchFrame window;
    private static Sketcher theApp;
}
