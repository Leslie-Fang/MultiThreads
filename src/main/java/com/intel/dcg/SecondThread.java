package com.intel.dcg;

public class SecondThread implements Runnable{
    private int i;
    {
        this.i = 0;
    }
    public void run(){
        while(i<10){
            synchronized(this){
                System.out.println(Thread.currentThread().getName()+" "+i);
                ++this.i;
            }
            try{
                Thread.currentThread().sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
