package page844;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class SketchFrame extends JFrame{
    public SketchFrame(String title){
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        JMenu elementMenu = new JMenu("Elements");
        
        menuBar.add(fileMenu);
        menuBar.add(elementMenu);
    }
    private JMenuBar menuBar = new JMenuBar();
}
