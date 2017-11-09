
package contructor;

public class A {
    int x, y, z, m, n;

    public A() {
    }

    public A(int x, int y, int z, int m, int n) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.m = m;
        this.n = n;
    }

   
    void sum(){
        System.out.println(x+y+z+m+n);
    }
    
}
