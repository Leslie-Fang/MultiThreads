package com.intel.dcg;

public class DrawThread extends Thread{
    Account myAccount;
    DrawThread(String name, Account myAccount){
        super(name);
        this.myAccount = myAccount;
    }
    void drawMoney(int number){
        if(number<=this.myAccount.getAccount()){
            this.myAccount.drawMoney(number);
            System.out.println("Draw Money Successfully!");
        }else{
            System.out.println("Failed,Lack of  Money!");
        }
    }
//    public void run(){
//        drawMoney
//    }
}
