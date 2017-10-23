import java.util.Scanner;
public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(true){
            int n = sc.nextInt();
            if(n>0){
                sum +=n;
            }else if(n<0){
                break;
            }
        }
        System.out.println("The sum is: "+sum);
    }
}
