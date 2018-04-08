package com.intel.dcg;

public class Account {
    int account;
    {
        account=0;
    }
    synchronized int add(){
        return ++account;
        //return this.getAccount();
    }
    synchronized int getAccount(){
        return this.account;
    }
}
