
import java.awt.FlowLayout;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class NewJApplet extends JApplet {
    
    @Override
    public void init() {
        JLabel label = new JLabel("This is my first applet.");
        setLayout(new FlowLayout());
        add(label);
    }
    
}
