package CommonMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CommonMenu {

    public static JMenuBar displayMenu(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem form1Item = new JMenuItem("Form 1");
        JMenuItem form2Item = new JMenuItem("Form 2");

        fileMenu.add(form1Item);
        form1Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Form1().setVisible(true);
            }

        });

        fileMenu.add(form2Item);
        form2Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Form2().setVisible(true);
            }

        });

        menuBar.add(fileMenu);
        return menuBar;
    }
}
