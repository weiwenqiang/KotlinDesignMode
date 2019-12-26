package com.wwq.seventeen

/**
 * Created by wwq on 2017/12/15.
 */
class SoundCard(mediator: Mediator) : Colleague(mediator) {
    fun soundPlay(data: String) = println("音频：$data")
}

class CDDevice(mediator: Mediator) : Colleague(mediator) {
    var data: String = ""
    fun read() = data
    fun load() {
        data = "视频数据,音频数据"
        //通知中介者 也就是主板数据改变
        mediator.changed(this)
    }
}

class CPU(mediator: Mediator) : Colleague(mediator) {
    var dataVideo: String = ""
    var dataSound: String = ""

    fun decodeData(data: String) {
        var tmp = data.split(",")
        // 解析音、视频数据
        dataVideo = tmp[0]
        dataSound = tmp[1]
        // 告诉中介者自身状态改变
        mediator.changed(this)
    }
}

class GraphicsCard(mediator: Mediator) : Colleague(mediator) {
    fun videoPlay(data: String) = println("视频：$data")
}

class MainBoard : Mediator() {
    var cdDevice: CDDevice? = null
    var cpu: CPU? = null
    var soundCard: SoundCard? = null
    var graphicsCard: GraphicsCard? = null

    fun handleCD(cdDevice: CDDevice): Unit {
        cpu!!.decodeData(cdDevice.read())
    }

    fun handleCPU(cpu: CPU) {
        soundCard!!.soundPlay(cpu.dataSound);
        graphicsCard!!.videoPlay(cpu.dataVideo);
    }

    override fun method() {
    }

    override fun changed(c: Colleague) {
        if (c === cdDevice) {
            //如果是光驱读取了数据
            handleCD(c)
        } else if (c === cpu) {
            //如果CPU读取了数据
            handleCPU(c)
        }
    }

    fun sCDDevice(cdDevice: CDDevice) {
        this.cdDevice = cdDevice
    }

    fun sCPU(cpu: CPU) {
        this.cpu = cpu
    }

    fun sSoundCard(soundCard: SoundCard) {
        this.soundCard = soundCard
    }

    fun sGraphicsCard(graphicsCard: GraphicsCard) {
        this.graphicsCard = graphicsCard
    }
}

fun main(args: Array<String>) {
    //构造主板对象
    var mediator: MainBoard = MainBoard()
    //分别构造各个零部件
    val cd = CDDevice(mediator)
    val cpu = CPU(mediator)
    val vc = GraphicsCard(mediator)
    val sc = SoundCard(mediator)
    //将各个零部件安装到主板
    mediator.sCDDevice(cd)
    mediator.sCPU(cpu)
    mediator.sGraphicsCard(vc)
    mediator.sSoundCard(sc)
    //完成后就可以放片了
    cd.load()
}