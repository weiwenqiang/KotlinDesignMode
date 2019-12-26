package com.wwq.ten

import java.util.*

/**
 * 解释器模式
 * Created by wwq on 2017/12/13.
 */
abstract class ArithmeticExpression{
    abstract fun interpreter():Int
}

class NumExpression(val num:Int) :ArithmeticExpression(){
    override fun interpreter(): Int = num
}
abstract class OperatorExpression(val exp1:ArithmeticExpression, val exp2:ArithmeticExpression) :ArithmeticExpression(){

}
class AdditionExpression(val add1:ArithmeticExpression, val add2:ArithmeticExpression) :OperatorExpression(add1, add2){
    override fun interpreter(): Int = add1.interpreter() + add2.interpreter()
}

class SubtractionExpression(val sub1:ArithmeticExpression, val sub2:ArithmeticExpression) :OperatorExpression(sub1,sub2){
    override fun interpreter(): Int =exp1.interpreter() - exp2.interpreter()
}

class Calculator(expression: String) {
    //声明一个Stack栈存储并操作所有相关的解释器
    private val mExpStack = Stack<ArithmeticExpression>()
    init {
        //声明两个ArithmeticExpression类型的临时变量，存储运算符左右两边的数字解释器
        var exp1: ArithmeticExpression
        var exp2: ArithmeticExpression
        //根据空格分割表达式字符串
        val elements = expression.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        /**
         * 循环遍历表达式元素数组
         */
        var i = 0
        while (i < elements.size) {
            //判断运算符号
            when (elements[i][0]) {
                '+' -> {
                    //将栈中的解释器弹出作为运算符号左边的解释器
                    exp1 = mExpStack.pop()
                    //同时将运算符号数组下标下一个元素构造为一个数字解释器
                    exp2 = NumExpression(Integer.valueOf(elements[++i])!!)
                    //通过上面两个数字解释器构造加法运算解释器
                    mExpStack.push(AdditionExpression(exp1, exp2))
                }
                '-' -> {
                    //将栈中的解释器弹出作为运算符号左边的解释器
                    exp1 = mExpStack.pop()
                    //同时将运算符号数组下标下一个元素构造为一个数字解释器
                    exp2 = NumExpression(Integer.valueOf(elements[++i])!!)
                    //通过上面两个数字解释器构造加法运算解释器
                    mExpStack.push(SubtractionExpression(exp1, exp2))
                }
                else//如果为数字
                ->
                    /**
                     * 如果不是运算符则为数字
                     * 若是数字，直接构造数字解释器并压入栈
                     */
                    mExpStack.push(NumExpression(Integer.valueOf(elements[i])!!))
            }
            i++
        }
    }

    fun calculate(): Int = mExpStack.pop().interpreter()
}

fun main(args: Array<String>) {
    println(Calculator("153 + 3589 + 118 - 555 - 597 - 66").calculate())
}
