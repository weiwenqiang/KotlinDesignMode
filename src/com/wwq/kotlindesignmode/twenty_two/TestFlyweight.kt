package com.wwq.twenty_two

import java.util.Random
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by wwq on 2017/12/16.
 */
interface Ticket {
    fun showTicketInfo(bunk: String)
}

class TrainTicket(var from: String// 始发地
                  , var to: String// 目的地
) : Ticket {
    var bunk: String? = null// 铺位
    var price: Int = 0

    override fun showTicketInfo(bunk: String) {
        price = Random().nextInt(300)
        println("购买 从 $from 到 $to 的 $bunk 火车票，价格：$price")
    }
}

object TicketFactory {
    internal var sTicketMap: MutableMap<String, Ticket> = ConcurrentHashMap()

    fun getTicket(from: String, to: String): Ticket {
        val key = from + "-" + to
        if (sTicketMap.containsKey(key)) {
            println("使用缓存 == 》 $key")
            return sTicketMap[key] as Ticket
        } else {
            println("创建对象 == 》 $key")
            val ticket = TrainTicket(from, to)
            sTicketMap.put(key, ticket)
            return ticket
        }
    }
}

fun main(args: Array<String>) {
    val ticket01 = TicketFactory.getTicket("北京", "青岛")
    ticket01.showTicketInfo("上铺")
    val ticket02 = TicketFactory.getTicket("北京", "青岛")
    ticket02.showTicketInfo("下铺")
    val ticket03 = TicketFactory.getTicket("北京", "青岛")
    ticket03.showTicketInfo("坐铺")
}