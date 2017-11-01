package toolBarSimple;

import java.awt.BorderLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import toolBarJFrame.ToolBarJFrame;

public class ToolBarExample {

    public ToolBarExample() {
        JFrame frame = new JFrame("This is title");
        JToolBar toolBar = new JToolBar("");
        Icon icon = new ImageIcon(getClass().getResource("Open24.gif"));
        JButton btnOpen = new JButton("Open", icon);
        BorderLayout brLayout = new BorderLayout();

        frame.setLayout(brLayout);
        frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);
        frame.setSize(500,200);
        toolBar.add(btnOpen);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        
        
        ToolBarExample obj = new ToolBarExample();
    }
}
