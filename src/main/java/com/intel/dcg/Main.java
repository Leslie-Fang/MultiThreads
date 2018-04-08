package com.intel.dcg;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello World!");
        Account myAccount = new Account();
//        System.out.println(myTestAdd.add());
        new FirstThread(myAccount).start();
        new FirstThread(myAccount).start();
        //new FirstThread(myTestAdd).start();
    }
}
