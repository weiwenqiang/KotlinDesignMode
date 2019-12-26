package com.wwq.seven

/**
 * 策略模式
 * Created by wwq on 2017/12/11.
 */
interface CalculateStrategy {
    fun calculatePrice(km: Int): Int
    fun calculateName():String
}

class BusStrategy : CalculateStrategy {
    override fun calculateName(): String ="公交策略"

    override fun calculatePrice(km: Int): Int {
        // 超过10公里的总距离
        var extraTotal = km - 10
        // 超过的距离是5公里的倍数
        var extraFactor = extraTotal / 5
        // 超过的距离对5公里取余
        var fraction = extraTotal % 5
        // 计算价格
        var price = 1 + extraFactor * 1

        return if (fraction > 0) ++price else price
    }
}

class SubwayStrategy : CalculateStrategy {
    override fun calculateName(): String ="地铁策略"
    override fun calculatePrice(km: Int): Int =
            when (km) {
                in 1..6 -> 3
                in 6..12 -> 4
                in 12..22 -> 5
                in 22..32 -> 6
                else -> 7
            }
}

class TaxiStrategy : CalculateStrategy{
    override fun calculateName(): String ="出租车策略"
    override fun calculatePrice(km: Int): Int = km*2
}

class TranficCalculator(val mStrategy:CalculateStrategy){
    fun calculatePrice(km:Int):Int = mStrategy.calculatePrice(km)
    fun calculateName():String = mStrategy.calculateName()
}

fun main(args: Array<String>) {
    var calculator:TranficCalculator =TranficCalculator(TaxiStrategy())
    println("${calculator.calculateName()}16公里的价格为：${calculator.calculatePrice(16)}元")
    calculator = TranficCalculator(BusStrategy())
    println("${calculator.calculateName()}16公里的价格为：${calculator.calculatePrice(16)}元")
    calculator = TranficCalculator(SubwayStrategy())
    println("${calculator.calculateName()}16公里的价格为：${calculator.calculatePrice(16)}元")
}