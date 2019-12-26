package com.wwq.sixteen

import java.util.*

/**
 * Created by wwq on 2017/12/15.
 */
abstract class Staff {
    var name: String
    var kpi: Int

    constructor(name: String) {
        this.name = name
        kpi = Random().nextInt(10)
    }

    abstract fun accept(visitor: Visitor)
}

interface Visitor {
    //访问工程师类型
    fun visit(engineer: Engineer)

    //访问经理类型
    fun visit(leader: Manager)
}

class Engineer(name: String) : Staff(name) {
    override fun accept(visitor: Visitor) = visitor.visit(this)
    fun getCodeLines() = Random().nextInt(10 * 10000)
}

class Manager(name: String) : Staff(name) {
    var products: Int = Random().nextInt(10)
    override fun accept(visitor: Visitor) = visitor.visit(this)
    fun mProducts():Int = products
}

class BusinessReport {
    var mStaffs: LinkedList<Staff> = LinkedList<Staff>()

    constructor() {
        mStaffs.add(Manager("王经理"))
        mStaffs.add(Engineer("工程师-Shawn.Xiong"))
        mStaffs.add(Engineer("工程师-Kael"))
        mStaffs.add(Engineer("工程师-Chaossss"))
        mStaffs.add(Engineer("工程师-Tiiime"))
    }

    fun showReport(visitor: Visitor) {
        for (staff in mStaffs) {
            staff.accept(visitor)
        }
    }
}

class CEOVisitor : Visitor {
    override fun visit(engineer: Engineer) = println("工程师：${engineer.name},KPI：${engineer.kpi}")
    override fun visit(mgr: Manager) = println("经理：${mgr.name},KPI：${mgr.kpi},新产品数量：${mgr.mProducts()}")
}

class CTOVisitor : Visitor {
    override fun visit(engineer: Engineer) = println("工程师：${engineer.name},代码行数：${engineer.getCodeLines()}")
    override fun visit(mgr: Manager) = println("经理：${mgr.name},产品数量：${mgr.mProducts()}")

}

fun main(args: Array<String>) {
    var report = BusinessReport()
    println("=========给CEO看的报表=========")
    report.showReport(CEOVisitor())
    println("=========给CTO看的报表=========")
    report.showReport(CTOVisitor())
}