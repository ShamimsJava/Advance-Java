package page813;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;

public class TryCardLayout extends JApplet implements ActionListener {

    CardLayout card = new CardLayout(50, 50);

    @Override
    public void init() {
        Container content = getContentPane();
        content.setLayout(card);

        JButton button;
        for (int i = 1; i <= 6; i++) {
            content.add(button = new JButton("Card " + i));
            button.addActionListener(this);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.next(getContentPane());
    }
}
