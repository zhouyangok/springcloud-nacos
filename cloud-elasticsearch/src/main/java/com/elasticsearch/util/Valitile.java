package com.elasticsearch.util;

/**
 * @ClassName Valitile
 * @Description: TODO
 * @Author zhouyang
 * @Date 2020/7/15 下午9:40.
 */

public class Valitile {

    public volatile int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Valitile test = new Valitile();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
