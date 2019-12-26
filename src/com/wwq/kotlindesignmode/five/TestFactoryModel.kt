package com.wwq.five

/**
 * 工厂模式
 * Created by wwq on 2017/12/11.
 */
abstract class Product {
    abstract fun method()
}

class ConcreteProductA : Product() {
    override fun method() = println("我是具体的产品A")
}

class ConcreteProductB : Product() {
    override fun method() = println("我是具体的产品B")
}

abstract class Factory {
    abstract fun <T : Product> createProduct(clz: Class<T>): T
}

class ConcreteFactory : Factory() {
    override fun <T : Product> createProduct(clz: Class<T>): T {
        var p: T? = null
        try {
            p = Class.forName(clz.name).newInstance() as T
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return p as T
    }
}

fun main(args: Array<String>) {
    var factory: Factory = ConcreteFactory()
    var p: Product = factory.createProduct(ConcreteProductB::class.java)
    p.method()

}