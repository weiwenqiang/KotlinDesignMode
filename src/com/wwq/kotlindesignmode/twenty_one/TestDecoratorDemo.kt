package com.wwq.twenty_one

/**
 * Created by wwq on 2017/12/16.
 */
abstract class Person {
    abstract fun dressed()
}

abstract class PersonCloth(var mPerson: Person) : Person() {
    override fun dressed() {
        mPerson.dressed()
    }
}

class ExpensiveCloth(mPerson: Person) : PersonCloth(mPerson) {

    private fun dressShirt() {
        println("穿件短袖")
    }

    private fun dressLeather() {
        println("穿件皮衣")
    }

    private fun dressJean() {
        println("穿件牛仔裤")
    }

    override fun dressed() {
        super.dressed()
        dressShirt()
        dressLeather()
        dressJean()
    }


}

class Boy : Person() {
    override fun dressed() {
        println("穿了内衣内裤")
    }
}

class CheapCloth(mPerson: Person) : PersonCloth(mPerson) {
    private fun dressShorts() {
        println("穿件短袖")
    }

    override fun dressed() {
        super.dressed()
        dressShorts()
    }
}

fun main(args: Array<String>) {
    val person = Boy()

    val clothCheap = CheapCloth(person)
    clothCheap.dressed()

    val clothExpensive = ExpensiveCloth(person)
    clothExpensive.dressed()
}