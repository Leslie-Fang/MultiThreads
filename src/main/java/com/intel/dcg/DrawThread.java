package com.intel.dcg;

public class DrawThread extends Thread{
    Account myAccount;
    DrawThread(String name, Account myAccount){
        super(name);
        this.myAccount = myAccount;
    }
    boolean drawMoney(int number){
        boolean res=false;
        synchronized(this){
            if(number<=this.myAccount.getAccount()){
                int bankLeft = this.myAccount.drawMoney(number);
                System.out.println(Thread.currentThread().getName()+": Draw Money Successfully! Left:"+bankLeft);
                res =  true;
            }else{
                System.out.println("Failed,Lack of Money!");
                res = false;
            }
        }
        return res;
    }
    public void run(){
        while(drawMoney(10)){
            try{
                sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
