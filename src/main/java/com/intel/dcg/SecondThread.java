package com.intel.dcg;

public class SecondThread implements Runnable{
    private int i;
    {
        this.i = 0;
    }
    public void run(){
        for(this.i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
