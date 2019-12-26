package com.wwq.two

/**
 * Created by wwq on 2017/11/28.
 */
class LazyThreadSafeSynchronized private constructor(){
    companion object{
        private var instance:LazyThreadSafeSynchronized ?= null
    }

    @Synchronized
    fun get():LazyThreadSafeSynchronized{
        if(instance == null) instance = LazyThreadSafeSynchronized()
        return instance!!
    }
}