package com.wwq.thirteen

/**
 * 备忘录模式
 * Created by wwq on 2017/11/28.
 */
data class MemotoKt(var mCheckpoint: Int, var mLifeValue: Int, var mWeapon: String)

class CaretakerKt(var mMemoto:MemotoKt) {
    /**
     * 存档
     */
    fun archive(memoto: MemotoKt) = { mMemoto = memoto }

    /**
     * 获取存档
     */
    fun getMemoto(): MemotoKt = mMemoto
}

data class CallOfDutyKt(var mCheckpoint:Int = 1,var mLifeValue:Int = 100,var mWeapon:String = "沙漠之鹰"){
    // 玩游戏
    fun play(){
        println("打游戏：第 $mCheckpoint 关 奋战杀敌中")
        mLifeValue-=10
        println("进度升级啦")
        mCheckpoint++
        println("到达 第 $mCheckpoint 关")
    }

    // 退出游戏
    fun quit(){
        println("-------------------")
        println("退出前的游戏属性：${toString()}")
        println("退出游戏")
        println("-------------------")
    }

    // 创建备忘录
    fun createMemoto():MemotoKt=(MemotoKt(mCheckpoint,mLifeValue,mWeapon))

    // 恢复游戏
    fun restore(memoto:MemotoKt){
        mCheckpoint=memoto.mCheckpoint
        mLifeValue=memoto.mLifeValue
        mWeapon= memoto.mWeapon
        println("恢复后的游戏属性：${toString()}")
    }
}

fun main(args: Array<String>) {
    //构建游戏对象
    var game:CallOfDutyKt = CallOfDutyKt()
    //1.打游戏
    game.play()

    var caretaker:CaretakerKt = CaretakerKt(game.createMemoto())
    //游戏存档
    caretaker.archive(game.createMemoto())
    //退出游戏
    game.quit()
    //恢复游戏
    var newGame:CallOfDutyKt = CallOfDutyKt()
    newGame.restore(caretaker.getMemoto())
}