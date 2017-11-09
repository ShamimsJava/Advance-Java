package shamim.interfaceEx;

public class Account implements Balance {
    double balance = 500000;
    double deposite;
    double withdraw;
    
    
    @Override
    public double deposite() {
        return 0;
    }

    @Override
    public double withdraw() {
        return 0;
    }

    @Override
    public double checkBalance() {
        return 0;
    }
    
}
