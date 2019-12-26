package com.wwq.nine

/**
 * 责任链模式
 * Created by wwq on 2017/12/12.
 */
abstract class Leader {
    var nextHandler: Leader? = null

    fun handleRequest(money: Int) {
        if (money <= limit) {
            handle(money)
        } else {
            if (nextHandler != null) {
                nextHandler!!.handleRequest(money)
            }
        }
    }

    abstract var limit: Int
    abstract fun handle(money: Int): Unit
}

class GroupLeader : Leader() {
    override var limit: Int = 1000
    override fun handle(money: Int) = println("组长批复报销${money}元")
}

class Manager : Leader() {
    override var limit: Int = 5000
    override fun handle(money: Int) = println("主管批复报销${money}元")
}

class Director : Leader() {
    override var limit: Int = 10000
    override fun handle(money: Int) = println("经理批复报销${money}元")
}

class Boss : Leader() {
    override var limit: Int = Int.MAX_VALUE
    override fun handle(money: Int) = println("老板批复报销${money}元")
}

fun main(args: Array<String>) {
    var groupLeader = GroupLeader()
    var director = Director()
    var manager = Manager()
    var boss = Boss()

    groupLeader.nextHandler = director
    director.nextHandler = manager
    manager.nextHandler = boss

    groupLeader.handleRequest(50000)
}