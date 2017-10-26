package page847;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class SketchFrame extends JFrame{
    public SketchFrame(String title){
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        JMenu elementMenu = new JMenu("Elements");
        
        newItem = fileMenu.add("New");
        openItem = fileMenu.add("Open");
        closeItem = fileMenu.add("Close");
        fileMenu.addSeparator();
        saveItem = fileMenu.add("Save");
        saveAsItem = fileMenu.add("Save As...");
        fileMenu.addSeparator();
        printItem = fileMenu.add("Print");
        
        elementMenu.add(lineItem = new JRadioButtonMenuItem("Line", true));
        elementMenu.add(rectangleItem = new JRadioButtonMenuItem("Rectangle", false));
        elementMenu.add(cirleItem = new JRadioButtonMenuItem("Circle", false));
        elementMenu.add(curveItem = new JRadioButtonMenuItem("Curve", false));
        ButtonGroup types = new ButtonGroup();
        
        types.add(lineItem);
        types.add(rectangleItem);
        types.add(cirleItem);
        types.add(curveItem);
        
        elementMenu.addSeparator();
        
        elementMenu.add(redItem = new JCheckBoxMenuItem("Red", false));
        elementMenu.add(yellowItem = new JCheckBoxMenuItem("Yellow", false));
        elementMenu.add(greenItem = new JCheckBoxMenuItem("Green", false));
        elementMenu.add(blueItem = new JCheckBoxMenuItem("Blue", true));
        
        menuBar.add(fileMenu);
        menuBar.add(elementMenu);
    }
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem newItem, openItem, closeItem, saveItem, saveAsItem, printItem;
    private JRadioButtonMenuItem lineItem, rectangleItem, cirleItem, curveItem, textItem;
    private JCheckBoxMenuItem redItem, yellowItem, greenItem, blueItem;
}
