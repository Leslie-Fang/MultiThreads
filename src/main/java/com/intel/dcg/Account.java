package com.intel.dcg;

public class Account {
    private String accountNO;
    private int balance;
    Account(){
        this.balance = 0;
    }
    Account(String accountNO,int balance){
        this.balance = balance;
        this.accountNO = accountNO;

    }
    synchronized int add(){
        return ++balance;
    }
    synchronized int getAccount(){
        return this.balance;
    }
    int drawMoney(int number){
        return this.balance - number;
    }
}
