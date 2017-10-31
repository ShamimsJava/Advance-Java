package CommoMenuBar;

import java.awt.event.*;
import javax.swing.*;

public class CommonMenuBar {

    public static JMenuBar commonMenu(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem jframe1Item = new JMenuItem("Frame 1");
        JMenuItem jframe2Item = new JMenuItem("Frame 2");
        JMenuItem exitItem = new JMenuItem("Exit");
        

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        fileMenu.add(jframe1Item);
        fileMenu.add(jframe2Item);
        fileMenu.add(exitItem);

        jframe1Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Frame1().setVisible(true);
            }

        });

        jframe2Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Frame2().setVisible(true);
            }

        });
        
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        return menuBar;
    }
}
