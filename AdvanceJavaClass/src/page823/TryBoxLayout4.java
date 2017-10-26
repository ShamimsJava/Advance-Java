package page823;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class TryBoxLayout4 {

    static JFrame aWindow = new JFrame("This is title");

    public static void main(String[] args) {
        Toolkit theKit = aWindow.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        Dimension d = new Dimension();
        aWindow.setBounds(wndSize.width / 4, wndSize.height / 4, wndSize.width / 2, wndSize.height / 2);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box left = Box.createVerticalBox();
        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton rbutton;
        radioGroup.add(rbutton = new JRadioButton("Red"));
        left.add(rbutton);
        radioGroup.add(rbutton = new JRadioButton("Green"));
        left.add(rbutton);
        radioGroup.add(rbutton = new JRadioButton("Blue"));
        left.add(rbutton);
        radioGroup.add(rbutton = new JRadioButton("Yellow"));
        left.add(rbutton);

        Box right = Box.createVerticalBox();
        right.add(new JCheckBox("Dashed"));
        right.add(new JCheckBox("Thick"));
        right.add(new JCheckBox("Rounded"));

        Box top = Box.createHorizontalBox();
        top.add(left);
        top.add(right);

        JPanel bottomPanel = new JPanel();
        Border edge = BorderFactory.createRaisedBevelBorder();
        JButton button;
        Dimension size = new Dimension(80, 20);
        bottomPanel.add(button = new JButton("Defaults"));
        bottomPanel.setBorder(edge);
        button.setPreferredSize(size);
        bottomPanel.add(button = new JButton("OK"));
        button.setBorder(edge);
        button.setPreferredSize(size);
        bottomPanel.add(button = new JButton("Cancel"));
        button.setBorder(edge);
        button.setPreferredSize(size);

        Container content = aWindow.getContentPane();
        content.setLayout(new BorderLayout());
        content.add(top, BorderLayout.CENTER);
        content.add(bottomPanel, BorderLayout.SOUTH);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(new TitledBorder(new EtchedBorder(), "Line Properties"));
        leftPanel.add(left, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(new TitledBorder(new EtchedBorder(), "Line Properties"));
        rightPanel.add(right, BorderLayout.CENTER);

        top.add(leftPanel);
        top.add(Box.createHorizontalStrut(5));
        top.add(rightPanel);

        bottomPanel.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.black, 1),
                BorderFactory.createBevelBorder(BevelBorder.RAISED)));

        BoxLayout box = new BoxLayout(content, BoxLayout.Y_AXIS);

        content.setLayout(box);
        content.add(top);
        content.add(bottomPanel);
        aWindow.pack();
        aWindow.setVisible(true);
    }
}
