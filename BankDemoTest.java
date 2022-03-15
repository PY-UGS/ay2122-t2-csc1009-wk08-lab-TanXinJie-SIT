import java.util.Scanner;

public class BankDemoTest{
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        CheckingAccount acc = new CheckingAccount(1, 0);
        System.out.println("How much would you like to deposit?");
        acc.deposit(sc.nextDouble());
        double input;
        while (true){
            System.out.println("How much would you like to withdraw?");
            input = sc.nextDouble();
            if (input < 0){
                System.exit(0);
            }
            try{
                acc.withdraw(input);
            }
            catch (InsufficientFundsException e){
                System.out.printf(e + "\nSorry, but your account is short by: $%.2f\n", e.getAmount());
                System.exit(0);
            }
        }
    }
}

class CheckingAccount{
    double balance;
    int number;
    
    public CheckingAccount(int number, double balance){
        this.number = number;
        this.balance = balance;
    }
    
    public void deposit(double val){
        this.balance +=  val;
    }
    
    public void withdraw(double val) throws InsufficientFundsException{
        if (val > this.balance) throw new InsufficientFundsException(val - this.balance);
        this.balance -= val;
        System.out.printf("This balance after withdraw is: $%.2f\n", this.balance);
    }
    
    /*public double getBalance(){
        return balance;
    }*/
}

class InsufficientFundsException extends Exception{
    private double amount;
    public InsufficientFundsException(double amount){
        this.amount = amount;
    }
    
    public double getAmount(){
        return amount;
    }
}
