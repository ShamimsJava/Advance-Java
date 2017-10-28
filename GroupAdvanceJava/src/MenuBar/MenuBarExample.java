package MenuBar;

import java.awt.event.InputEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBarExample extends JFrame {
    JMenuBar menuBar;
    JMenu menu1, menu2, menu3, menu4;
    JMenuItem item1, item2, item3, item4, item5;

    public MenuBarExample() {
        setLayout(null);
        setSize(400, 400);

        menuBar = new JMenuBar();

        menu1 = new JMenu("File");
        item1 = new JMenuItem("New");
        menu3 = new JMenu("Save");
        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(menu3);
        item2 = new JMenuItem("Urmi");
        item3 = new JMenuItem("Megha");
        menu3.add(item2);
        menu3.add(item3);
        menu4 = new JMenu("Shamim");
        menu3.add(menu4);
        item4 = new JMenuItem("Shihab");
        menu4.add(item4);
        
        
        menu2 = new JMenu("Help");

        menuBar.add(menu1);
        menuBar.add(menu2);
        setJMenuBar(menuBar);
        
        menu1.setMnemonic('F');
        item1.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        item2.setAccelerator(KeyStroke.getKeyStroke('U', InputEvent.CTRL_DOWN_MASK));
        
        
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MenuBarExample();
    }

}


/*
Log in form
sign in --> dash board
File -> new, save, save as

sign up --> registration page
submit --> information of registration


*/