package com.intel.dcg;

public class Main {
    public class InnerClass{
        String name;
        InnerClass(){}
        InnerClass(String name){
            this.name = name;
        }
        String getName(){
            return this.name;
        }
    }
    public static void main(String[] args){
//        Account myAccount = new Account();
//        new FirstThread(myAccount).start();
//        new FirstThread(myAccount).start();
//        SecondThread st = new SecondThread();
//        new Thread(st,"新secondThread1").start();
//        new Thread(st,"新secondThread2").start();
//        Account myAccount1 = new Account("leslie", 100);
//        Account myAccount2 = new Account("Bob", 10);
//        DrawThread myDrawThread = new DrawThread("Thread1",myAccount1);
//        myDrawThread.start();

        InnerClass innerClass = new Main().new InnerClass("leslie");
        System.out.println(innerClass.getName());
    }
}
