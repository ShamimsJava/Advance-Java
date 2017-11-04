
public class NewClass {

    public static void main(String[] args) {
            String x = "10";
            Integer y = 10;
            System.out.println(System.identityHashCode(Integer.parseInt(x)));
            System.out.println(System.identityHashCode(y));
            
            System.out.println(Integer.parseInt(x)==y);
    }
}
