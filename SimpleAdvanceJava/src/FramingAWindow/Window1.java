package FramingAWindow;

import javax.swing.JFrame;

public class Window1 {
    public static void main(String[] args) {
        JFrame j = new JFrame("This is title");
//        JFrame j = new JFrame();
//        j.setTitle("This is title");
//        System.out.println(j.getTitle());
        
        j.setBounds(200, 200, // position
                500, 200); // size
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
