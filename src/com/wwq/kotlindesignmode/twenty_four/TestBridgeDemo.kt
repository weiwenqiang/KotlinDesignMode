package com.wwq.twenty_four

/**
 * Created by wwq on 2017/12/16.
 */
abstract class CoffeeAdditives {
    /**
     * 具体要往咖啡里添加什么也是由子类实现
     */
    abstract fun addSomthing(): String
}


abstract class Coffee(var impl: CoffeeAdditives) {
    /**
     * 咖啡具体是什么样的由子类决定
     */
    abstract fun makeCoffee()
}

class LargeCoffee(impl: CoffeeAdditives) : Coffee(impl) {
    override fun makeCoffee() {
        println("大杯的 $impl 咖啡")
    }
}

class Ordinary : CoffeeAdditives() {
    override fun addSomthing(): String {
        return "原味"
    }
}

class SmallCoffee(impl: CoffeeAdditives)// TODO Auto-generated constructor stub
    : Coffee(impl) {

    override fun makeCoffee() {
        println("小杯的 $impl 咖啡")
    }
}

class Sugar : CoffeeAdditives() {
    override fun addSomthing(): String ="加糖"
}

fun main(args: Array<String>) {
    // 原味
    val implOrdinary = Ordinary()

    // 准备糖类
    val implSugar = Sugar()

    // 大杯咖啡 原味
    val largeCoffeeOrdinary = LargeCoffee(implOrdinary)
    largeCoffeeOrdinary.makeCoffee()

    // 小杯咖啡 原味
    val smallCoffeeOrdinary = SmallCoffee(implOrdinary)
    smallCoffeeOrdinary.makeCoffee()

    // 大杯咖啡 加糖
    val largeCoffeeOrdinarySugar = LargeCoffee(implSugar)
    largeCoffeeOrdinarySugar.makeCoffee()

    // 小杯咖啡 加糖
    val smallCoffeeOrdinarySugar = SmallCoffee(implSugar)
    smallCoffeeOrdinarySugar.makeCoffee()
}