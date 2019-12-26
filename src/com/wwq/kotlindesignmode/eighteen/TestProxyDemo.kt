package com.wwq.eighteen

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
/**
 * Created by wwq on 2017/12/16.
 */
interface ILawsuit {
    fun submit()
    fun burden()
    fun defend()
    fun finish()
}

class XiaoMin : ILawsuit {
    override fun submit() = println("老板拖欠工资！特此申请仲裁！")
    override fun burden() = println("这是合同书和过去一年的银行工资流水！")
    override fun defend() = println("证据确凿！不需要再说什么了！")
    override fun finish() = println("诉讼成功！判决老板即日起七天内结算工资！")
}

class Lawyer(var mLawsuit: ILawsuit) : ILawsuit {
    override fun submit() = mLawsuit.submit()
    override fun burden() = mLawsuit.burden()
    override fun defend() = mLawsuit.defend()
    override fun finish() = mLawsuit.finish()
}

class DynamicProxy(private val obj: Any) : InvocationHandler {
    @Throws(Throwable::class)
    override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any {
        val result = method.invoke(obj, *args)
        return result
    }
}

fun main(args: Array<String>) {
    //构造一个小民
    val xiaomin = XiaoMin()
    //构造一个动态代理
    val proxy = DynamicProxy(xiaomin)
    //获取被代理类小民的ClassLoader
    val loader = xiaomin.javaClass.classLoader
    //动态构造一个代理者律师
    val lawyer = Proxy.newProxyInstance(loader, arrayOf<Class<*>>(ILawsuit::class.java), proxy) as ILawsuit
    //代理律师工作
    lawyer.submit()
    lawyer.burden()
    lawyer.defend()
    lawyer.finish()
}