package com.wwq.eleven

/**
 * 命令模式
 * Created by wwq on 2017/12/13.
 */
interface Command {
    fun execute(): Unit
}

class Receiver{
    var action = println("执行具体的操作")
}

class Invoker(val command:Command){
    var action = command.execute()
}

class ConcreteCommand(val receiver:Receiver) :Command{
    override fun execute() = receiver.action

}

fun main(args: Array<String>) {
    //构造一个接收者对象
    var receiver = Receiver()
    //根据接收者对象构造一个命令对象
    var command = ConcreteCommand(receiver)
    //根据具体的对象构造一个命令对象
    var invoker = Invoker(command)
    //执行请求方法
    invoker.action
}