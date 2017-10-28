package MenuExample;

import java.awt.event.InputEvent;
import javax.swing.*;

public class MenuDetails {
    public static void main(String[] args) {
        JFrame f = new JFrame("Title");
        
        JMenuBar mb = new JMenuBar();
        
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        JMenu open = new JMenu("Open");
        JMenu server = new JMenu("From Server");
        
        JMenuItem nw = new JMenuItem("New");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As..");
        JMenuItem computer = new JMenuItem("From Computer");
        JMenuItem github = new JMenuItem("GitHub");
        JMenuItem gitlab = new JMenuItem("GitLab");
        JMenuItem bitbucket = new JMenuItem("BitBucket");
        
        f.setBounds(200, 200, 500, 400);
        
        f.setJMenuBar(mb);
        mb.add(file);
        mb.add(help);
        file.add(nw);
        file.add(save);
        file.add(saveAs);
        file.addSeparator();
        file.add(open);
        
        open.add(computer);
        open.add(server);
        server.add(github);
        server.add(gitlab);
        server.add(bitbucket);
        
        file.setMnemonic('F');
        nw.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
