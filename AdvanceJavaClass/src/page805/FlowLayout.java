package page805;

import java.awt.*;
import javax.swing.*;

public class FlowLayout {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("Title");
        Toolkit toolkit = jframe.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jframe.setBounds(dimension.width/4, dimension.height/4, dimension.width/2, dimension.height/2);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout();
        Container container = jframe.getContentPane();
       // container.setLayout(flowLayout);
        
        
    }
}
