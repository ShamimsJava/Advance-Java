package page878;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.SwingUtilities;

public class Sketcher implements WindowListener {

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

        ////////////////////////
        window.addWindowListener(this);

        window.setVisible(true);
    }
    private static SketchFrame window;

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        window.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    private static Sketcher theApp;
}
