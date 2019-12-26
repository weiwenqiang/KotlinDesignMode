package com.wwq.four

import java.util.*

/**
 * 原型模式
 * Created by wwq on 2017/11/28.
 */
class WordDocument : Cloneable{
    var mText:String = ""
    var mImages:ArrayList<String> = ArrayList<String>()
    public override fun clone(): WordDocument {
        try {
            var doc:WordDocument = super.clone() as WordDocument
            doc.mText = this.mText
            //对mImages 对象也调用clone函数，进行深拷贝
            doc.mImages = this.mImages.clone() as ArrayList<String>
            return doc
        }catch (e:Exception){

        }
        return null!!
    }

    /**
     * 打印文档内容
     */
    fun showDocument(){
        println("------------- Word Content Start -------------")
        println("Text : $mText")
        println("Images List : ${mImages.forEach{ println(it)}}")
        println("------------- Word Content End -------------")
    }
}

fun main(args: Array<String>) {
//    //1.构建文档对象
    var originDoc:WordDocument = WordDocument()
//    //2.编辑文档，添加图片等
    originDoc.mText="这是一片文档"

//    originDoc.mImages =listOf("图片1","图片2","图片3")
    originDoc.mImages.add("图片1")
    originDoc.mImages.add("图片2")
    originDoc.mImages.add("图片3")
    originDoc.showDocument()
    //以原始文档为原型，拷贝一份副本
    var doc2:WordDocument = originDoc.clone()
    doc2.showDocument()
    //修改文档副本，不会影响原始文档
    doc2.mText="这是修改过的Doc2文本"
    doc2.mImages.add("哈哈jpg")
    doc2.showDocument()

    originDoc.showDocument()
}