package com.wwq.twenty_four

/**
 * Created by wwq on 2017/12/16.
 */
interface Implementor {
    /**
     * 实现抽象部分的具体方法
     */
    fun operationImpl()
}

abstract class Abstraction
/**
 * 通过实现部分对象的引用构造抽象部分的对象
 * @param mImplementor
 */
(private val mImplementor: Implementor) {

    /**
     * 通过调用实现部分具体的方法实现具体的功能
     */
    open fun operation() {
        mImplementor.operationImpl()
    }
}

class ConcreteImplementorA : Implementor {
    override fun operationImpl() {
        //具体的实现
    }
}

class ConcreteImplementorB : Implementor {
    override fun operationImpl() {
        //具体的实现
    }
}

class RefinedAbstraction(mImplementor: Implementor) : Abstraction(mImplementor) {
    /**
     * 对父类抽象部分中的方法进行扩展
     */
    override fun operation() {
        // TODO Auto-generated method stub
        super.operation()
    }
}

fun main(args: Array<String>) {
    //客户调用逻辑
}