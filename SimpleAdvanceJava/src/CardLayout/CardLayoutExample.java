package CardLayout;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CardLayoutExample extends JFrame implements ActionListener {

    private CardLayout card;
    private JButton b;
    private Container c;

    public CardLayoutExample() {
        cardLay();
    }

    public void cardLay() {
        setSize(400, 400);
        card = new CardLayout(50, 50);
        c = getContentPane();
        c.setLayout(card);

        for (int i = 0; i < 10; i++) {
            c.add(b = new JButton("Button " + i));
            b.addActionListener(this);
        }

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.next(c);
    }

    public static void main(String[] args) {
       CardLayoutExample cl =  new CardLayoutExample();
    }
}
