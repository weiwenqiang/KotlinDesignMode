package com.wwq.fourteen

/**
 * Created by wwq on 2017/12/14.
 */
interface Company {
    fun iterator(): Iterator<Any>
}

data class Employee(var name: String, var age: Int, var sex: String, var position: String)

class MinIterator(val list: List<Employee>) : Iterator<Any> {
    var position: Int = 0
    override fun hasNext(): Boolean {
        return !(position > list.size - 1 || list.get(position) == null)
    }

    override fun next(): Any? = list.get(position++)
}

class HuiIterator(val array: Array<Employee?>) : Iterator<Any> {
    var position: Int = 0
    override fun hasNext(): Boolean {
        return !(position > array.size - 1 || array[position] == null)
    }

    override fun next(): Any? = array[position++]
}

class CompanyHui : Company {
    var array = kotlin.arrayOfNulls<Employee>(3)

    init {
        array[0] = Employee("辉哥", 108, "男", "程序猿")
        array[1] = Employee("小红", 98, "男", "程序猿")
        array[2] = Employee("小辉", 88, "男", "程序猿")
    }

    override fun iterator(): Iterator<Any> = HuiIterator(array)
}

class CompanyMin : Company {
    var list = arrayListOf<Employee>(
            Employee("小民", 96, "男", "程序猿"),
            Employee("小云", 22, "女", "测试"),
            Employee("小芳", 18, "女", "测试"),
            Employee("可儿", 21, "女", "设计"),
            Employee("朗情", 19, "女", "设计"))

    override fun iterator(): Iterator<Any> = MinIterator(list)
}

fun main(args: Array<String>) {
    var min = CompanyMin()
    check(min.iterator())
    var hui = CompanyHui()
    check(hui.iterator())
}

fun check(iterator: Iterator<Any>) {
    while (iterator.hasNext()) {
        println(iterator.next().toString())
    }
}