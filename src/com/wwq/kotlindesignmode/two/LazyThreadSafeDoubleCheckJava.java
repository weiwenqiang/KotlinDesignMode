package com.wwq.kotlindesignmode.two;

/**
 * Created by wwq on 2017/11/28.
 */
public class LazyThreadSafeDoubleCheckJava {
    private static volatile LazyThreadSafeDoubleCheckJava INSTANCE;

    private LazyThreadSafeDoubleCheckJava(){
        System.out.println("LazyThreadSafeSynchronizedJava");
    }

    public static LazyThreadSafeDoubleCheckJava getInstance(){
        if (INSTANCE == null){
            synchronized (LazyThreadSafeDoubleCheckJava.class){
                if (INSTANCE == null){
                    INSTANCE = new LazyThreadSafeDoubleCheckJava();
                }
            }
        }
        return INSTANCE;
    }
}
