package com.wwq.fourteen

import java.util.*

/**
 * Created by wwq on 2017/12/14.
 */
interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T?
}

interface Aggregate<T> {
    fun add(obj: T): Unit
    fun remove(obj: T)
    fun iterator(): Iterator<T>
}

class ConcreteIterator<T> : Iterator<T> {
    var list = ArrayList<T>()
    var cursor = 0

    constructor(list: ArrayList<T>) {
        this.list = list
    }

    override fun hasNext(): Boolean = (cursor != list.size)
    override fun next(): T? {
        var obj: T? = null
        if (this.hasNext()) {
            obj = this.list.get(cursor++)
        }
        return obj
    }
}

class ConcreteAggregate<T> : Aggregate<T> {
    var list = ArrayList<T>()
    override fun add(obj: T) {
        list.add(obj)
    }

    override fun remove(obj: T) {
        list.remove(obj)
    }

    override fun iterator(): Iterator<T> = ConcreteIterator<T>(list)
}

fun main(args: Array<String>) {
    var a = ConcreteAggregate<String>()
    a.add("Aige")
    a.add("Studio\n")
    a.add("SM")
    a.add(" Brother")

    var i: Iterator<String> = a.iterator()
    while (i.hasNext()) {
        println(i.next())
    }
}