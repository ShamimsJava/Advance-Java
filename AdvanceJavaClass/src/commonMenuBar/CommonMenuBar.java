package commonMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CommonMenuBar {
    public static JMenuBar displayMenu(JFrame f){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem jframeItem = new JMenuItem("JFrameExample");
        
        jframeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new JFrameExample().setVisible(true);
            }
        });
     
        menuBar.add(fileMenu);
        fileMenu.add(jframeItem); 
        return menuBar;
    }
}
