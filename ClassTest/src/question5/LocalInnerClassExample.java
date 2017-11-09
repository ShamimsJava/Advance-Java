package question5;

public class LocalInnerClassExample {
    public void method1(){
        class LocalInner{
            int a = 10;
            public void method2(){
               
                System.out.println("This is method2........");
            }
        }
    }
}
