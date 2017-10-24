package WindowExample;

import java.awt.*;

public class Points {
    public static void main(String[] args) {
        Point p1 = new Point();
        System.out.println(p1);
        
        Point p2 = new Point(50,60);
        System.out.println(p2.getLocation());
        System.out.println((int)p2.getX());
        p1.move(40, 30);
        System.out.println(p1);
        p1.translate(10, 30);
        System.out.println(p1);
        System.out.println(p1.equals(p2));
        
        Point p3 = new Point();
        p3.x = 10;
        p3.y = 20;
        System.out.println(p3);
        
        Point p4 = new Point();
        p4.setLocation(100, 200);
        System.out.println(p4.getLocation());
    }
}

/*
Point
setLocation()
getLocation()
equals()
move()
translate()
*/