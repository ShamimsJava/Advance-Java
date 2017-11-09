package question4;

public class InnerClassApp {

    public static void main(String[] args) {
        InnerClassExample obj1 = new InnerClassExample();
        InnerClassExample.InnerClass obj2 = obj1.new InnerClass();
        InnerClassExample.InnerClass.InnerClass2 obj3 = obj2.new InnerClass2();

        System.out.println("The value of a: " + obj1.a);
        System.out.println("The value of b: " + obj1.b);
        System.out.println(obj1.method1());
        System.out.println("The value of c: " + obj2.c);
        System.out.println("The value of d: " + obj2.d);
        System.out.println(obj2.method2());
        System.out.println("The value of e: " + obj3.e);
        System.out.println("The value of f: " + obj3.f);
        System.out.println(obj3.method3());
    }
}
