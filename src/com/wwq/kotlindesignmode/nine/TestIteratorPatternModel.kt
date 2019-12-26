package com.wwq.nine

/**
 * 责任链模式
 * Created by wwq on 2017/12/12.
 */
abstract class AbstractRequest(val any: Any) {
    abstract var getRequestLevel: Int
}

class Request1(any: Any) : AbstractRequest(any) {
    override var getRequestLevel: Int = 1
}

class Request2(any: Any) : AbstractRequest(any) {
    override var getRequestLevel: Int = 2
}

class Request3(any: Any) : AbstractRequest(any) {
    override var getRequestLevel: Int = 3
}

abstract class AbstractHandler {
    var nextHandler: AbstractHandler? = null
    fun handleRequest(request: AbstractRequest) {
        if (getHandleLevel == request.getRequestLevel) {
            handle(request)
        } else {
            if (nextHandler != null) {
                nextHandler!!.handleRequest(request)
            } else {
                println("All of handler can not handle the request.")
            }
        }
    }

    abstract var getHandleLevel: Int
    abstract fun handle(request: AbstractRequest): Unit
}

class Handler1() : AbstractHandler() {
    override var getHandleLevel: Int = 1
    override fun handle(request: AbstractRequest) = println("Handler1 handle request:${request.getRequestLevel}")
}

class Handler2() : AbstractHandler() {
    override var getHandleLevel: Int = 2
    override fun handle(request: AbstractRequest) = println("Handler2 handle request:${request.getRequestLevel}")
}

class Handler3() : AbstractHandler() {
    override var getHandleLevel: Int = 3
    override fun handle(request: AbstractRequest) = println("Handler3 handle request:${request.getRequestLevel}")
}

fun main(args: Array<String>) {
    var handler1 = Handler1()
    var handler2 = Handler2()
    var handler3 = Handler3()

    handler1.nextHandler = handler2
    handler2.nextHandler = handler3

    var request1:AbstractRequest = Request1("Request1")
    var request2:AbstractRequest = Request2("Request2")
    var request3:AbstractRequest = Request3("Request3")

    handler1.handleRequest(request1)
    handler2.handleRequest(request2)
    handler3.handleRequest(request3)
}