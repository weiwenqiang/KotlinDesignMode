package com.wwq.twenty

/**
 * Created by wwq on 2017/12/16.
 */
interface FiveVolt {
    val volt5: Int
}

class Volt220 {
    val volt220: Int
        get() = 220
}

class VoltAdapter(internal var mVolt220: Volt220) : FiveVolt {

    fun getmVolt220(): Int {
        return mVolt220.volt220
    }

    override val volt5: Int
        get() = 5
}

fun main(args: Array<String>) {
    val adapter = VoltAdapter(Volt220())
    println("输出电压：" + adapter.volt5)
}
