package ExtraMenu;

import java.awt.event.InputEvent;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class TryMenu2 extends JFrame{
    JMenuBar menuBar;
    JMenu menu1, menu2, menu3, menu4;
    JMenuItem item1, item2, item3, item4, item5;

    public TryMenu2() {
        setLayout(null);
        setSize(400, 400);
        
        menuBar = new JMenuBar();
        
        menu1 = new JMenu("File");
        item1 = new JMenuItem("New");
        menu1.add(item1);
        menu1.addSeparator();
        menu3 = new JMenu("Open");
        item3 = new JMenuItem("From Computer");
        menu3.add(item3);
        menu3.addSeparator();
        menu4 = new JMenu("From Remote");
        menu3.add(menu4);
        item4 = new JMenuItem("GitHub");
        item5 = new JMenuItem("BitBucket");
        menu4.add(item4);
        menu4.add(item5);
        
        menu1.add(menu3);
        menu1.addSeparator();
        
        item2 = new JMenuItem("Exit");
        menu1.add(item2);      
        menu2 = new JMenu("Help");
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        
        setJMenuBar(menuBar);

        menu1.setMnemonic('F');
        menu2.setMnemonic('H');
        menu3.setMnemonic('O');
        menu4.setMnemonic('R');
        
        item1.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        item2.setAccelerator(KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK));
        item3.setAccelerator(KeyStroke.getKeyStroke('C', CTRL_DOWN_MASK));
        item4.setAccelerator(KeyStroke.getKeyStroke('G', CTRL_DOWN_MASK));
        item5.setAccelerator(KeyStroke.getKeyStroke('B', CTRL_DOWN_MASK));
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TryMenu2();
    }
}
