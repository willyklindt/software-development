public class MainBankAccount {

    public static void main(String[] args) {
        SavingAccount savings = new SavingAccount("Will", 420, 5000, 0.02);
        savings.add_interest();
        System.out.println("The balance is: " + savings.getBalance());
    }
}

class BankAccount {
    double balance;
    String owner;
    Integer accountID;
    public BankAccount (String owner, Integer accountID, double amount){
        this.balance = amount;
        this.owner = owner;
        this.accountID = accountID;
        
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount; //balance = balance + amount
    }
    
    public boolean withdraw (double amount){
        boolean result = false;
        if (amount <= balance){
            balance -= amount; //balance = balance - amount
            result = true;
        }

        return result;
    }
}

class SavingAccount extends BankAccount{
    double interest_rate;
    public SavingAccount(String owner, Integer accountID, double amount, double rate){
        super(owner, accountID, amount);
        this.interest_rate = rate;
    }
    public void add_interest(){
        balance += balance * interest_rate; // balance = balance +(balance*interest_rate)
    }
}
