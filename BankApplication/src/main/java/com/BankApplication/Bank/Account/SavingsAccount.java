package com.BankApplication.Bank.Account;


public class SavingsAccount extends AccountClass {
    private double interestRate;


    public SavingsAccount(int accountNumber, double balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void setInterestRate(int interestRate){
        this.interestRate = interestRate;
    }

    public void applyInterestRate() {
        double interest = getBalance() * (interestRate/100);
        balance += interest;
    }
}