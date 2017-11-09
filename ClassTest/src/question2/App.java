package question2;

public  class App extends AbstractClassExample {
    public static void main(String[] args) {
        App app = new App();
        app.method2();
        app.method1();
    }

    @Override
    void method1() {
        System.out.println("This is method1..............");
    }
}
