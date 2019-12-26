package com.wwq.kotlindesignmode.two;

/**
 * Created by wwq on 2017/11/28.
 */
public class LazyNotThreadSafeJava {
    private static LazyNotThreadSafeJava INSTANCE;

    private LazyNotThreadSafeJava(){
        System.out.println("LazyNotThreadSafeJava");
    }

    public static LazyNotThreadSafeJava getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LazyNotThreadSafeJava();
        }
        return INSTANCE;
    }
}
