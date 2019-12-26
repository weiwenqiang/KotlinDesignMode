package com.wwq.two

import java.util.*

/**
 * 单例模式
 * Created by wwq on 2017/11/28.
 */
object CEO : Staff() {
    override fun work() {
    }
}

open class Staff {
    open fun work() {
    }
}

class VP : Staff() {
    override fun work() {

    }
}

class Company {
    var allStaffs = ArrayList<Staff>();
    fun addStaff(staff: Staff) {
        allStaffs.add(staff)
    }

    fun showAllStaffs() = allStaffs.forEach {
        println(it.toString())
    }
}

fun main(args: Array<String>) {
    var cp = Company()

    var ceo1 = CEO
    var ceo2 = CEO
    cp.addStaff(ceo1)
    cp.addStaff(ceo2)

    var vp1 = VP()
    var vp2 = VP()
    cp.addStaff(vp1)
    cp.addStaff(vp2)

    var staff1 = Staff()
    var staff2 = Staff()
    var staff3 = Staff()
    cp.addStaff(staff1)
    cp.addStaff(staff2)
    cp.addStaff(staff3)

    cp.showAllStaffs()
}