package com.BankApplication.Bank;


import com.BankApplication.Bank.Account.AccountClass;

public class CustomerClass {
    private int customerId;
    private String name;
    private AccountClass account;

    CustomerClass(int customerId, String cname, AccountClass account){
        this.customerId = customerId;
        this.name = cname;
        this.account = account;
    }

    public int getCustomerId(){
        return customerId;
    }

    public String getName(){
        return name;
    }
}

