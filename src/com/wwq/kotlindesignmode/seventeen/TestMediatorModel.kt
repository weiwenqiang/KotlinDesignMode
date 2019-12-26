package com.wwq.seventeen

/**
 * Created by wwq on 2017/12/15.
 */
abstract class Colleague {
    var mediator: Mediator

    constructor(mediator: Mediator) {
        this.mediator = mediator
    }
//    abstract fun action()
}

class ConcreteColleagueA(mediator: Mediator) : Colleague(mediator) {
    //    override
    fun action() = println("ColleagueA 将信息递交给中介者处理")
}

class ConcreteColleagueB(mediator: Mediator) : Colleague(mediator) {
    //    override
    fun action() = println("ColleagueB 将信息递交给中介者处理")
}

abstract class Mediator() {
    var colleagueA: ConcreteColleagueA = ConcreteColleagueA(this)
    var colleagueB: ConcreteColleagueB = ConcreteColleagueB(this)
    abstract fun method()
    abstract fun changed(c: Colleague)
}

class ConcreteMediator(collA: ConcreteColleagueA, collB: ConcreteColleagueB) : Mediator() {
    override fun changed(c: Colleague) {
    }

    override fun method() {
        colleagueA.action()
        colleagueB.action()
    }
}