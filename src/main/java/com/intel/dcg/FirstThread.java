package com.intel.dcg;

public class FirstThread extends Thread{
    private int i;
    Account target;
    FirstThread(){};
    FirstThread(Account myTestAdd){
        this.target = myTestAdd;
    }
    public void run(){
        for(this.i=0;i<10;i++){
            //System.out.println(getName()+" "+i);
            //实现一，添加synchronized代码块
            synchronized(target){
                this.target.add();
                System.out.println(getName()+" "+this.target.getAccount());
            }
            //实现二,设置account的add方法和getAccount方法为synchronized
           //System.out.println(getName()+" "+this.target.add());
            try{
                sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
