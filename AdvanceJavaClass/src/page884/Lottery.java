package page884;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Lottery extends JApplet {
    static int[] getNumbers(){
        int[] numbers = new int[numberCount];
        int candidate = 0;
        for (int i = 0; i < numberCount; i++) {
            for(;;){
                candidate = values[choice.nextInt(values.length)];
                for (int j = 0; j < i; j++) {
                    if(candidate==numbers[j]){
                        continue search;
                    }
                }
                numbers[i] = candidate;
                break;
            }
        }
        return numbers;
    }
    @Override
    public void init() {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                createGUI();
            }
        });
    }

    public void createGUI() {
        Container content = getContentPane();
        content.setLayout(new GridLayout(0,1));
        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.cyan, Color.blue), "Every One a Winner!"));
        int[] choices = getNumbers();
        for (int i = 0; i < numberCount; i++) {
            luckyNumbers[i] = new Selection(choices[i]);
            buttonPane.add(luckyNumbers[i]);
        }
        content.add(buttonPane);
        
        JPanel controlPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        JButton button;
        Dimension buttonSize = new Dimension(100,20);
        
        controlPane.add(button = new JButton("Lucky Numbers!"));
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.addActionListener(new HandleControlButton(PICK_LUCKY_NUMBER));
        button.setPreferredSize(buttonSize);
    }

    class Selection extends JButton implements ActionListener

    {
        public Selection(int value){
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

    }
    
    class HandleControlButton implements ActionListener{

        public HandleControlButton(){
        
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    
    }
    
    final static int numberCount = 6;
    final static int minValue = 1;
    final static int maxValue = 49;
    static int[] values = new int[maxValue-minValue+1];
    static{
        for(int i = 0; i<values.length; i++)
            values[i] = i + minValue;
    }
    private Selection[] luckyNumbers = new Selection[numberCount];
    
    final public static int PICK_LUCKY_NUMBER = 1;
    final public static int COLOR = 2;
    Color flipColor = new Color(Color.YELLOW.getRGB()^Color.RED.getRGB());
    Color startColor = Color.YELLOW;
    private static Random choice = new Random();
}
