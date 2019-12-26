package com.wwq.siz

/**
 * 抽象工厂模式
 * Created by wwq on 2017/12/11.
 */
abstract class AbstractProductA {
    abstract fun method()
}

abstract class AbstractProductB {
    abstract fun method()
}

abstract class AbstractFactory {
    abstract fun createProductA(): AbstractProductA
    abstract fun createProductB(): AbstractProductB
}

class ConcreteProductA1 : AbstractProductA() {
    override fun method() = println("具体产品A1的方法")
}

class ConcreteProductA2 : AbstractProductA() {
    override fun method() = println("具体产品A2的方法")
}

class ConcreteProductB1 : AbstractProductB() {
    override fun method() = println("具体产品B1的方法")
}

class ConcreteProductB2 : AbstractProductB() {
    override fun method() = println("具体产品B2的方法")
}

class ConcreteFactory1 : AbstractFactory() {
    override fun createProductA(): AbstractProductA = ConcreteProductA1()
    override fun createProductB(): AbstractProductB = ConcreteProductB1()
}

class ConcreteFactory2 : AbstractFactory() {
    override fun createProductA(): AbstractProductA = ConcreteProductA2()
    override fun createProductB(): AbstractProductB = ConcreteProductB2()
}

fun main(args: Array<String>) {
    var a1: AbstractProductA = ConcreteFactory1().createProductA()
    a1.method()
    var a2: AbstractProductA = ConcreteFactory2().createProductA()
    a2.method()
    var b1: AbstractProductB = ConcreteFactory1().createProductB()
    b1.method()
    var b2: AbstractProductB = ConcreteFactory2().createProductB()
    b2.method()
}