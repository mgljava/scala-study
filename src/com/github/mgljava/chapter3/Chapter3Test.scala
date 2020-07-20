package com.github.mgljava.chapter3

import scala.collection.mutable.ArrayBuffer

object Chapter3Test {
  def main(args: Array[String]): Unit = {
    // 定长数组
    val nums: Array[Int] = new Array[Int](10) // 10个整数的数组，都初始化为0
    for (num <- nums) {
      println(num)
    }

    val s: Array[String] = Array("Hello", "World")
    println(s(1))
    println(s(0))

    s(0) = "welcome" // 可以改变数组的值
    for (s1 <- s) {
      println(s1)
    }
    s.toBuffer // 转为数组缓冲

    println("------变长数组 ArrayBuffer-----")
    // 变长数组 ArrayBuffer
    val b = ArrayBuffer[Int]() // 一个空的数组缓冲，准备存放整数
    b += 1 // += 在尾端添加元素 1
    b += (2, 3, 4, 5) // 添加集合

    b ++= Array(8, 90, 20) // 添加集合
    b.trimEnd(2) // 移除尾部元素

    b.insert(2, 189, 292) // 在下标为2之前插入元素 189, 292
    println(b)

    b.toArray // 数组缓冲转为数组

    println("-----遍历数组和数组缓冲-----")
    // 遍历数组和数组缓冲
    for (i <- b.indices) {
      println(b(i))
    }

    for (i <- b.indices.reverse) {
      println(b(i))
    }

    // 数组转换
    println("-----数组转换-------")
    val a = Array(2, 3, 5, 7, 8, 11)
    val array = for (elem <- a) yield 2 * elem // for(...) yield exp. 循环创建一个类型与原始集合相同的心机和
    for (a <- array) {
      println(a)
    }

    // for(... if ...)
    val array1 = for (elem <- a if elem % 2 == 0) yield 3 * elem
    printArray("array1", array1)

    val array2 = a.filter(_ % 2 == 0).map(2 * _)
    printArray("array2", array2)


    val bb = Array(9, 23, 54, -2, 32, -6, -4, -12, 90)
    // 如果要使用sum方法，元素类型必须是整数类型：整形，浮点数，BigInteger/BigDecimal
    val sum = bb.sum
    println(sum)
    println("min: " + bb.min + ", max: " + bb.max)

    scala.util.Sorting.quickSort(bb)
    println("quickSort: " + bb.toBuffer)

    val i = bb.count(_ > 0)
    println("i > 0 count: " + i)

    // 多维数组
    val array3 = Array.ofDim[Int](3, 4)
    array3(2)(3) = 1
  }

  def printArray(name: String, array: Array[Int]): Unit = {
    println("---" + name + "----")
    for (elem <- array) {
      println(elem)
    }
  }
}
