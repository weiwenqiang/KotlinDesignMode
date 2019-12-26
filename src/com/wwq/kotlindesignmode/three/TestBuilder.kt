package com.wwq.three

/**
 * Builder模式
 * Created by wwq on 2017/11/28.
 */
abstract class Builder {
    //设置主机
    abstract fun buildBoard(board: String)
    //设置显示器
    abstract fun buildDisplay(display: String)
    //设置操作系统
    abstract fun buildOS()
    //创建Computer
    abstract fun create(): Computer
}

abstract class Computer() {
    var mBoard: String = ""
    var mDisplay: String = ""
    var mOS: String = ""

    abstract fun setOS()
    override fun toString(): String {
        return "Computer(mBoard='$mBoard', mDisplay='$mDisplay', mOS='$mOS')"
    }


}

class Macbook : Computer() {
    override fun setOS() {
        mOS = "Mac OS X 10.10"
    }
}

open class Director(var mBuilder: Builder) {
    /**
     * 构建对象
     */
    fun construct(board: String, display: String) {
        mBuilder.buildBoard(board)
        mBuilder.buildDisplay(display)
        mBuilder.buildOS()
    }
}

class MacbookBuilder : Builder() {
    var mComputer: Computer = Macbook()

    override fun buildBoard(board: String) {
        mComputer.mBoard = board
    }

    override fun buildDisplay(display: String) {
        mComputer.mDisplay = display
    }

    override fun buildOS() {
        mComputer.setOS()
    }

    override fun create(): Computer = mComputer

}

fun main(args: Array<String>) {
    //构建器
    var builder = MacbookBuilder()
    var pcDirector = Director(builder)
    //封装构建过程
    pcDirector.construct("英特尔主板", "Retina显示器")
    println("Computer Info : ${builder.create().toString()}")

}