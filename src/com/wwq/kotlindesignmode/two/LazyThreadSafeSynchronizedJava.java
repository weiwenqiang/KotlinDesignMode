package com.wwq.kotlindesignmode.two;

/**
 * Created by wwq on 2017/11/28.
 */
public class LazyThreadSafeSynchronizedJava {
    private static LazyThreadSafeSynchronizedJava INSTANCE;

    private LazyThreadSafeSynchronizedJava(){
        System.out.println("LazyThreadSafeSynchronizedJava");
    }

    public static synchronized LazyThreadSafeSynchronizedJava getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LazyThreadSafeSynchronizedJava();
        }
        return INSTANCE;
    }
}
