package page784;

import java.awt.*;

public class PlayingPoints {

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(210, 410);
        System.out.println(p1);
        p1.move(100, 200);
        System.out.println(p1);
        p1.setLocation(200, 400);
        System.out.println(p1.getLocation());
        System.out.println(p1);
        p1.translate(10, 10);
        System.out.println(p1.getLocation());
        System.out.println(p1);
        System.out.println(p1.equals(p2));
    }
}

/*
Point
move()
setLocation()
getLocation()
translate()
equals()
*/
