package contructor;

import java.util.ArrayList;
import java.util.List;

public class B {

    public static void main(String[] args) {
//        int x=10, y=12, z = 13, m = 14, n = 50;
//        A a = new A(x,y,z,m,n);
//        
//        
//        a.sum();
//        
//        List<String> list = new ArrayList<>();
//        list.add("52");
//        list.add("Shamim");
//        
//        int[] arr = new int[2];
//        arr[0] = 10;
//        arr[1] = 12;
//        arr[2] = 13;
//        System.out.println(arr[2]);

        String x = "10";
        String y = "20";
        System.out.println(Integer.parseInt(x) + Integer.parseInt(y));
        
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        System.out.println(list.get(1));
        
    }
}
