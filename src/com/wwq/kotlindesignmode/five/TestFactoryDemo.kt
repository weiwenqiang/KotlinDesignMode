package com.wwq.five

/**
 * 工厂模式
 * Created by wwq on 2017/12/11.
 */
abstract class AudiCar {
    abstract fun drive()
    abstract fun selfNavigation()
}

class AudiQ3 : AudiCar() {
    override fun selfNavigation() = println("Q3 启动自动导航！")
    override fun drive() = println("Q3 启动啦！")
}

class AudiQ5 : AudiCar() {
    override fun selfNavigation() = println("Q5 启动自动导航！")
    override fun drive() = println("Q5 启动啦！")
}

class AudiQ7 : AudiCar() {
    override fun selfNavigation() = println("Q7 启动自动导航！")
    override fun drive() = println("Q7 启动啦！")
}

abstract class AudiFactory() {
    abstract fun <T : AudiCar> createAudiCar(clz: Class<T>): T
}

class AudiCarFactory : AudiFactory() {
    override fun <T : AudiCar> createAudiCar(clz: Class<T>): T {
        var car: T? = null
        try {
            car = Class.forName(clz.name).newInstance() as T
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return car as T
    }
}

fun main(args: Array<String>) {
    var factory: AudiFactory = AudiCarFactory()

    var q3: AudiQ3 = factory.createAudiCar(AudiQ3::class.java)
    q3.drive()
    q3.selfNavigation()

    var q5: AudiQ5 = factory.createAudiCar(AudiQ5::class.java)
    q5.drive()
    q5.selfNavigation()

    var q7: AudiQ7 = factory.createAudiCar(AudiQ7::class.java)
    q7.drive()
    q7.selfNavigation()
}