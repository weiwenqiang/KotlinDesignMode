package com.wwq.siz

/**
 * 抽象工厂模式
 * Created by wwq on 2017/12/11.
 */
interface ITire {
    fun tire()
}

interface IEngine {
    fun engine()
}

interface IBrake {
    fun brake()
}

abstract class CarFactory {
    abstract fun createTire(): ITire
    abstract fun createEngine(): IEngine
    abstract fun createBrake(): IBrake
}

class NormalTire : ITire {
    override fun tire() = println("普通轮胎")
}

class SUVTire : ITire {
    override fun tire() = println("越野轮胎")
}

class DomesticEngine : IEngine {
    override fun engine() = println("国产发动机")
}

class ImportEngine : IEngine {
    override fun engine() = println("进口发动机")
}

class NormalBrake : IBrake {
    override fun brake() = println("普通制动")
}

class SeniorBrake : IBrake {
    override fun brake() = println("高级制动")
}

class Q3Factory : CarFactory() {
    override fun createTire(): ITire = NormalTire()
    override fun createEngine(): IEngine = DomesticEngine()
    override fun createBrake(): IBrake = NormalBrake()
}

class Q7Factory :CarFactory(){
    override fun createTire(): ITire = SUVTire()
    override fun createEngine(): IEngine = ImportEngine()
    override fun createBrake(): IBrake = SeniorBrake()
}

fun main(args: Array<String>) {
    var factoryQ3:CarFactory = Q3Factory()
    factoryQ3.createBrake().brake()
    factoryQ3.createEngine().engine()
    factoryQ3.createTire().tire()
    println("-------------------")
    var factoryQ7:CarFactory = Q7Factory()
    factoryQ7.createBrake().brake()
    factoryQ7.createEngine().engine()
    factoryQ7.createTire().tire()
}