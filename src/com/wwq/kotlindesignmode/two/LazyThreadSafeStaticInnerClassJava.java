package com.wwq.kotlindesignmode.two;


/**
 * Created by wwq on 2017/11/28.
 */
public class LazyThreadSafeStaticInnerClassJava {
    private static class Holder{
        private static LazyThreadSafeStaticInnerClassJava INSTANCE = new LazyThreadSafeStaticInnerClassJava();
    }

    private LazyThreadSafeStaticInnerClassJava(){}

    public static LazyThreadSafeStaticInnerClassJava getInstance(){
        return Holder.INSTANCE;
    }

}
