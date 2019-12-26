package com.wwq.two

/**
 * Created by wwq on 2017/11/28.
 */
class LazyThreadSafeDoubleCheck private constructor(){
    companion object{
        val instance by lazy(mode =LazyThreadSafetyMode.SYNCHRONIZED){
            LazyThreadSafeDoubleCheck()
        }
    }
}