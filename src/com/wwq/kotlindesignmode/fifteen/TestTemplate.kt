package com.wwq.fifteen

/**
 * Created by wwq on 2017/12/15.
 */
open abstract class AbstractComputer {
    fun startUp() {
        println("--------------关机 START--------------")
        powerOn()
        checkHardware()
        loadOS()
        login()
        println("--------------关机 END--------------")
    }

    fun powerOn() = println("开启电源")
    open fun checkHardware() = println("硬件检查")
    fun loadOS() = println("载入操作系统")
    open fun login() = println("小白的计算机无验证，直接进入系统")
}

class CoderComputer : AbstractComputer() {
    override fun login() = println("程序员只需要进行用户和密码验证就可以了")
}

class MilitaryComputer : AbstractComputer() {
    override fun checkHardware() = println("检查硬件防火墙")
    override fun login() = println("进行指纹识别等复杂的用户验证")
}

fun main(args: Array<String>) {
    var comp:AbstractComputer =CoderComputer()
    comp.startUp()

    comp = MilitaryComputer()
    comp.startUp()
}