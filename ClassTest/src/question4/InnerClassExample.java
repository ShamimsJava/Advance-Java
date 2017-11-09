package question4;

public class InnerClassExample {

    int a = 10;
    int b = 20;

    public String method1() {
        return "This is method1....";
    }

    class InnerClass {

        int c = 30;
        int d = 40;

        public String method2() {
            return "This is method2....";
        }

        class InnerClass2 {

            int e = 50;
            int f = 60;

            public String method3() {
                return "This is method3....";
            }
        }
    }
}
