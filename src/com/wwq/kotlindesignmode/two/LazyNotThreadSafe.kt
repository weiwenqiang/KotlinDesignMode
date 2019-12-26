package com.wwq.two

/**
 * Created by wwq on 2017/11/28.
 */
class LazyNotThreadSafe {
    val instance by lazy(LazyThreadSafetyMode.NONE){
        LazyNotThreadSafe()
    }
}