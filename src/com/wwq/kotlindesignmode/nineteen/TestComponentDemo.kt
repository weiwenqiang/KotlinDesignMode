package com.wwq.nineteen

import java.util.ArrayList


/**
 * Created by wwq on 2017/12/16.
 */
abstract class Dir(var name: String) {
    var dirs = ArrayList<Dir>()
    abstract fun addDir(dir: Dir)
    abstract fun rmDir(dir: Dir)
    abstract fun clear()
    abstract fun print()
    abstract fun getFiles(): List<Dir>
}

class File(name: String) : Dir(name) {
    override fun addDir(dir: Dir) {
        throw UnsupportedOperationException("文件对象不支持该操作")
    }

    override fun rmDir(dir: Dir) {
        throw UnsupportedOperationException("文件对象不支持该操作")
    }

    override fun clear() {
        throw UnsupportedOperationException("文件对象不支持该操作")
    }

    override fun print() = print(name)
    override fun getFiles(): List<Dir> {
        throw UnsupportedOperationException("文件对象不支持该操作")
    }
}

class Folder(name: String) : Dir(name) {
    override fun addDir(dir: Dir) {
        dirs.add(dir)
    }

    override fun rmDir(dir: Dir) {
        dirs.remove(dir)
    }

    override fun clear() {
        dirs.clear()
    }

    override fun print() {
        print(name + "(")
        val iter = dirs.iterator()
        while (iter.hasNext()) {
            val dir = iter.next()
            dir.print()
            if (iter.hasNext()) {
                print(",")
            }
        }
        print(")")
    }

    override fun getFiles(): List<Dir> {
        return dirs
    }
}

fun main(args: Array<String>) {
    //构造一个目录对象表示C盘根目录
    val diskC = Folder("C")
    //C盘根目录下有一个文件ImbaMallLog.txt
    diskC.addDir(File("ImbaMallLog.txt"))
    //C盘根目录下还有3个子目录
    val dirWin = Folder("Windows")
    //windows目录下有文件explorer.exe
    dirWin.addDir(File("explorer.exe"))
    diskC.addDir(dirWin)
    //perflogs 目录
    val dirPer = Folder("PerfLogs")
    //perflogs 目录下有文件null.txt
    dirPer.addDir(File("null.txt"))
    diskC.addDir(dirPer)
    //Program File 目录
    val dirPro = Folder("Program File")
    //Program File 目录下有文件ftp.txt
    dirPro.addDir(File("ftp.txt"))
    diskC.addDir(dirPro)
    //打印出文件结构
    diskC.print()
}