package com.wwq.nineteen

import java.util.ArrayList


/**
 * Created by wwq on 2017/12/16.
 */
abstract class Component(var name: String) {
    abstract fun doSomething()
    abstract fun addChild(child: Component)
    abstract fun removeChild(child: Component)
    abstract fun getChildren(index: Int): Component
}

class Composite(name: String) : Component(name) {
    var components = ArrayList<Component>()
    override fun doSomething() {
        println(name)
        if (null != components) {
            for (c in components) {
                c.doSomething()
            }
        }
    }

    override fun addChild(child: Component) {
        components.add(child)
    }

    override fun removeChild(child: Component) {
        components.remove(child)
    }

    override fun getChildren(index: Int): Component = components.get(index)
}

class Leaf(name: String) : Component(name) {
    override fun doSomething() = println(name)

    override fun addChild(child: Component) {
        throw UnsupportedOperationException("叶子没有子节点")
    }

    override fun removeChild(child: Component) {
        throw UnsupportedOperationException("叶子没有子节点")
    }

    override fun getChildren(index: Int): Component {
        throw UnsupportedOperationException("叶子没有子节点")
    }

}

fun main(args: Array<String>) {
    //构造一个根节点
    val root = Composite("Root")
    //构造两个枝干节点
    val branch1 = Composite("Branch1")
    val branch2 = Composite("Branch2")
    //构造两个叶子节点
    val leaf1 = Leaf("Leaf1")
    val leaf2 = Leaf("Leaf2")
    //将叶子节点添加至枝干节点中
    branch1.addChild(leaf1)
    branch2.addChild(leaf2)
    //将枝干节点添加至根节点中
    root.addChild(branch1)
    root.addChild(branch2)
    //执行方法
    root.doSomething()
}