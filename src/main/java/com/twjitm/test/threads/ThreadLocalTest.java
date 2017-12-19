package com.twjitm.test.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 文江 on 2017/12/18.
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
          new Thread(){
                @Override
                public void run() {
                    System.out.println("当前线程"+Thread.currentThread().getName()+"系统分配的id="+Thread.currentThread().getId()+"threadlocal分配id="+ThreadId.get());
                }
            }.start();
        }
    }
    static  class ThreadId{
        private  static  AtomicInteger integer=new AtomicInteger(0);
        private  static  ThreadLocal<Integer> threadLocal=new ThreadLocal(){
            @Override
            protected Integer initialValue() {
            return  integer.getAndIncrement();
            }
        };
        public static int  get(){
            return  threadLocal.get();
        }

    }
}
