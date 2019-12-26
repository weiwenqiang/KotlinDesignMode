package com.wwq.eight

/**
 * 状态模式
 * Created by wwq on 2017/12/11.
 */
interface TvState{
    fun nextChannel()
    fun prevChannel()
    fun turnUp()
    fun turnDown()
}
interface PowerController{
    fun powerOn()
    fun powerOff()
}
class PowerOffState :TvState{
    override fun nextChannel() { }
    override fun prevChannel() { }
    override fun turnUp() { }
    override fun turnDown() {}
}

class PowerOnState :TvState{
    override fun nextChannel()= println("下一频道")
    override fun prevChannel()= println("上一频道")
    override fun turnUp()= println("调高音量")
    override fun turnDown() = println("调低音量")
}

class TvController(var mTvState:TvState) :PowerController{
    override fun powerOn() {
        mTvState = PowerOnState()
        println("开机了")
    }

    override fun powerOff() {
        mTvState = PowerOffState()
        println("关机了")
    }

    fun nextChannel(){mTvState.nextChannel()}
    fun prevChannel(){mTvState.prevChannel()}
    fun turnUp(){mTvState.turnUp()}
    fun turnDown(){mTvState.turnDown()}
}

fun main(args: Array<String>) {
    var tvController = TvController(PowerOffState())
    //设置开机状态
    tvController.powerOn()
    //下一频道
    tvController.nextChannel()
    //调高音量
    tvController.turnUp()
    //设置关机状态
    tvController.powerOff()
    //调高音量，此时不会生效
    tvController.turnUp()

}