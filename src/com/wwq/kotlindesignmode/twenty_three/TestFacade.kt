package com.wwq.twenty_three

/**
 * Created by wwq on 2017/12/16.
 */
interface Camera {
    fun open()
    fun takePicture()
    fun close()
}

class SamsungCamera : Camera {
    override fun open() = println("打开相机")
    override fun takePicture() = println("拍照")
    override fun close() = println("关闭相机")
}

interface Phone {
    fun dail()
    fun hangup()
}

class PhoneImpl : Phone {
    override fun dail() = println("打电话")
    override fun hangup() = println("挂断")
}

class MobilePhone {
    private val mPhone = PhoneImpl()
    private val mCamera = SamsungCamera()

    fun dail() {
        mPhone.dail()
    }

    fun videoChat() {
        println("--> 视频聊天接通中")
        mCamera.open()
        mPhone.dail()
    }

    fun hangup() {
        mPhone.hangup()
    }

    fun takePicture() {
        mCamera.open()
        mCamera.takePicture()
    }

    fun closeCamera() {
        mCamera.close()
    }
}

fun main(args: Array<String>) {
    val nexus6 = MobilePhone()
    //拍照
    nexus6.takePicture()
    //视频聊天
    nexus6.videoChat()
}