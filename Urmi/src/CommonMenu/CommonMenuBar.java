package CommonMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CommonMenuBar {
    public static JMenuBar displayMenu(JFrame f){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem frame1Item = new JMenuItem("Frame 1");
        JMenuItem frame2Item = new JMenuItem("Frame 2");
        JMenuItem frame3Item = new JMenuItem("Frame 3");
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        fileMenu.add(frame1Item);
        fileMenu.add(frame2Item);
        fileMenu.add(frame3Item);
        
        frame1Item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Frame1().setVisible(true);
            } 
        });
        
        frame2Item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Frame2().setVisible(true);
            } 
        });
        
        frame3Item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Frame3().setVisible(true);
            } 
        });
        return menuBar;
    }
}
