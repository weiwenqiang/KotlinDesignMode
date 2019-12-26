package com.wwq.twelve

import java.util.*

/**
 * 观察者模式
 * Created by wwq on 2017/12/13.
 */
data class Coder(val name:String) : Observer {
    override fun update(o: Observable?, arg: Any?) =println("Hi, $name, DevTechFrontier更新啦， 内容：$arg")
}
class DevTechFrontier : Observable(){
    fun postNewPublication(content:String){
        //标识状态或者内容发生改变
        setChanged()
        //通知所有观察者
        notifyObservers(content)
    }
}

fun main(args: Array<String>) {
    //被观察的角色
    var devTechFrontier = DevTechFrontier()
    //观察者
    var mrsimple = Coder("mr.simple")
    var coder1  = Coder("coder-1")
    var coder2  = Coder("coder-2")
    var coder3  = Coder("coder-3")
    //将观察者注册到可观察对象的观察者列表中
    devTechFrontier.addObserver(mrsimple)
    devTechFrontier.addObserver(coder1)
    devTechFrontier.addObserver(coder2)
    devTechFrontier.addObserver(coder3)

    devTechFrontier.postNewPublication("新的一期开发技术前线周报发布啦")
}