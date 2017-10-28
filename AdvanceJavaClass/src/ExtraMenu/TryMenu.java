package ExtraMenu;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TryMenu extends JFrame {

    JMenuBar menuBar;
    JMenu menu1, menu2, submenu;
    //FlowLayout fl;
    JMenuItem item1, item2, item3, h1, h2;

    public TryMenu() {
        //fl = new FlowLayout(FlowLayout.LEFT);
        setLayout(null);
        setSize(400, 400);
        menuBar = new JMenuBar();
        menu1 = new JMenu("File");
        item1 = new JMenuItem("New");
        item2 = new JMenuItem("Open");
        item3 = new JMenuItem("Exit");
        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menu1.add(item3);

        menu2 = new JMenu("Help");
        submenu = new JMenu("Submenu");
        menu2.add(submenu);

        menuBar.add(menu1);
        menuBar.add(menu2);
        setJMenuBar(menuBar);
        h1 = new JMenuItem("Live Support");
        h2 = new JMenuItem("Email Suport");
        submenu.add(h1);
        submenu.add(h2);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TryMenu();
    }
}
