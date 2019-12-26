package com.wwq.twenty_one

/**
 * Created by wwq on 2017/12/16.
 */
abstract class Component {
    /**
     * 抽象的方法，这个随你做
     * 同样地你也可以增加更多的抽象方法
     */
    abstract fun operate()
}

class ConcreteComponent : Component() {
    override fun operate() {
        //具体逻辑，这个随你做
    }
}

abstract class Decorator(val component: Component) : Component() {
    override fun operate() {
        component.operate()
    }
}

class ConcreteDecoratorA(component: Component) : Decorator(component) {

    override fun operate() {
        operateA()
        super.operate()
        operateB()
    }

    fun operateA() {
        println("A实现-装饰方法A")
    }

    fun operateB() {
        println("A实现-装饰方法B")
    }
}

class ConcreteDecoratorB(component: Component) : Decorator(component) {

    override fun operate() {
        operateA()
        super.operate()
        operateB()
    }

    fun operateA() {
        println("B实现-装饰方法A")
    }

    fun operateB() {
        println("B实现-装饰方法B")
    }
}

fun main(args: Array<String>) {
    // 构造被装饰的组件对象
    val component = ConcreteComponent()
    // 根据组件对象构造装饰者对象A并调用，此时于给组件对象增加装饰者A的功能方法
    val decorator = ConcreteDecoratorA(component)
    decorator.operate()
    // 根据组件对象构造装饰者对象B并调用，此时于给组件对象增加装饰者A的功能方法
    val decoratorB = ConcreteDecoratorB(component)
    decoratorB.operate()
}