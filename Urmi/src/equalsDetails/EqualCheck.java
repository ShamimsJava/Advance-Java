package equalsDetails;

public class EqualCheck {

    public static void main(String[] args) {
        int x = 15;
        int y = 15;
        
        Integer x2 = new Integer(20);
        Integer y2 = new Integer(20);
        
        Integer x3 = 25;
        Integer y3 = 25;
        
//        System.out.println(System.identityHashCode(x));
//        System.out.println(System.identityHashCode(y));
//        
//        System.out.println(System.identityHashCode(x2));
//        System.out.println(System.identityHashCode(y2));
    
        System.out.println(x==y);
        System.out.println(x2==y2);
        System.out.println(x3==y3);
        System.out.println(x3.equals(y3));
        
        System.out.println(x2.equals(y2));
    }
}

/*
==          check equality, check location

equals()    check equality

*/