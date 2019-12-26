package com.wwq.two

/**
 * Created by wwq on 2017/11/28.
 */
class LazyThreadSafeStaticInnerClass private constructor(){
    companion object{
        fun getInstance() = Holder.instance
    }

    private object Holder{
        val instance  = LazyThreadSafeStaticInnerClass()
    }
}