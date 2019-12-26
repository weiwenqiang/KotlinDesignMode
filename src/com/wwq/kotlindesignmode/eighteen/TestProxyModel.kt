package com.wwq.eighteen

/**
 * Created by wwq on 2017/12/16.
 */
abstract class Subject {
    abstract fun visit(): Unit
}

class RealSubject : Subject() {
    override fun visit() = println("RealSubject！")
}

class ProxySubject(var mSubject: RealSubject) : Subject() {
    override fun visit() {
        //通过真实主题引用的对象调用真实主题中的逻辑方法
        mSubject.visit()
    }
}

fun main(args: Array<String>) {
    //构造一个真实主题对象
    val real = RealSubject()
    //通过真实主题对象构造一个代理对象
    val proxy = ProxySubject(real)
    //调用代理的相关方法
    proxy.visit()
}