package page880;

import java.awt.AWTEvent;
import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import java.awt.event.WindowEvent;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SketchFrame extends JFrame{
    public SketchFrame(String title){
        setTitle(title);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenu elementMenu = new JMenu("Elements");
        fileMenu.setMnemonic('F');
        elementMenu.setMnemonic('E');

        newItem = fileMenu.add("New");
        openItem = fileMenu.add("Open");
        closeItem = fileMenu.add("Close");
        fileMenu.addSeparator();
        saveItem = fileMenu.add("Save");
        saveAsItem = fileMenu.add("Save As...");
        fileMenu.addSeparator();
        printItem = fileMenu.add("Print");

        newItem.setAccelerator(KeyStroke.getKeyStroke('N', CTRL_DOWN_MASK));
        openItem.setAccelerator(KeyStroke.getKeyStroke('O', CTRL_DOWN_MASK));
        saveItem.setAccelerator(KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK));
        printItem.setAccelerator(KeyStroke.getKeyStroke('P', CTRL_DOWN_MASK));
        
        elementMenu.add(lineItem = new JRadioButtonMenuItem("Line", true));
        elementMenu.add(rectangleItem = new JRadioButtonMenuItem("Rectangle", false));
        elementMenu.add(cirleItem = new JRadioButtonMenuItem("Circle", false));
        elementMenu.add(curveItem = new JRadioButtonMenuItem("Curve", false));
        ButtonGroup types = new ButtonGroup();

        types.add(lineItem);
        types.add(rectangleItem);
        types.add(cirleItem);
        types.add(curveItem);

        lineItem.setAccelerator(KeyStroke.getKeyStroke('L', CTRL_DOWN_MASK));
        rectangleItem.setAccelerator(KeyStroke.getKeyStroke('E', CTRL_DOWN_MASK));
        cirleItem.setAccelerator(KeyStroke.getKeyStroke('I', CTRL_DOWN_MASK));
        curveItem.setAccelerator(KeyStroke.getKeyStroke('V', CTRL_DOWN_MASK));
        
        elementMenu.addSeparator();

        JMenu colorMenu = new JMenu("Color");
        elementMenu.add(colorMenu);

        colorMenu.add(redItem = new JCheckBoxMenuItem("Red", false));
        colorMenu.add(yellowItem = new JCheckBoxMenuItem("Yellow", false));
        colorMenu.add(greenItem = new JCheckBoxMenuItem("Green", false));
        colorMenu.add(blueItem = new JCheckBoxMenuItem("Blue", true));

        redItem.setAccelerator(KeyStroke.getKeyStroke('R', CTRL_DOWN_MASK));
        yellowItem.setAccelerator(KeyStroke.getKeyStroke('Y', CTRL_DOWN_MASK));
        greenItem.setAccelerator(KeyStroke.getKeyStroke('G', CTRL_DOWN_MASK));
        blueItem.setAccelerator(KeyStroke.getKeyStroke('B', CTRL_DOWN_MASK));
        
        menuBar.add(fileMenu);
        menuBar.add(elementMenu);
        
        //////////////// New ///////////////////
        //enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    }
//    @Override
//    protected void processWindowEvent(WindowEvent e){
//        if(e.getID() == WindowEvent.WINDOW_CLOSING){
//            dispose();
//            System.exit(0);
//        }
//        super.processWindowEvent(e);
//    }
    
    //////////////////////////////////////////////
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem newItem, openItem, closeItem, saveItem, saveAsItem, printItem;
    private JRadioButtonMenuItem lineItem, rectangleItem, cirleItem, curveItem, textItem;
    private JCheckBoxMenuItem redItem, yellowItem, greenItem, blueItem;
}
