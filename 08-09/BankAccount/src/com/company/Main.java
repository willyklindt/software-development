package com.company;

public class Main {

    public static void main(String[] args) {
	    SavingAccount savings=new SavingAccount("Trump", 101, 1000000, 0.02);
        savings.add_interest();
        System.out.println("The balance is: $"+ savings.getBalance());
        CheckingAccount checking = new CheckingAccount("Trump", 102, 100, savings);
        checking.MakeCheck(1000);
        System.out.println("The savings balance is: $"+ savings.getBalance());
        System.out.println("The checking balance is: $"+ checking.getBalance());

    }
}


class BankAccount{ //Fordi der ikke står public foran class, kan man lave denne class i samme dokument som main.
    double balance;
    String owner;
    Integer accountID;
    public BankAccount (String owner, Integer accountID, double amount){ //Constructor
        this.owner=owner;
        this.accountID=accountID;
        this.balance=amount;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance+=amount; // balance = balance+amount
    }
    public boolean withdrawal(double amount){
        boolean result = false;
        if (amount<=balance){
            balance-=amount; //balance=balance-amount;
            result=true;
        }

        return result;
    }
}


class SavingAccount extends BankAccount{
    double interest_rate;
    public SavingAccount(String owner, Integer accountID, double amount, double rate){

        super(owner, accountID, amount);
        this.interest_rate=rate;

    }
    public void add_interest(){
        balance+=balance*interest_rate;
    }
}

class CheckingAccount extends BankAccount{
    SavingAccount overdraftaccount;
    public CheckingAccount(String owner, Integer accountID, double amount, SavingAccount od){
        super(owner, accountID, amount);
        this.overdraftaccount=od;
    }
    public boolean MakeCheck(double amount){
        boolean result=false;
        if (super.withdrawal(amount))
            result=true;
        else if(overdraftaccount.withdrawal(amount-balance)){

            balance=0.0;
            result = true;
        }

        return result;
    }
}


