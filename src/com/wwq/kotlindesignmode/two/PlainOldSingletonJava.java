package com.wwq.kotlindesignmode.two;

/**
 * Created by wwq on 2017/11/28.
 */
public class PlainOldSingletonJava {
    private static PlainOldSingletonJava INSTANCE = new PlainOldSingletonJava();

    private PlainOldSingletonJava(){
        System.out.println("PlainOldSingleton");
    }

    public static PlainOldSingletonJava getInstance(){
        return INSTANCE;
    }
}
