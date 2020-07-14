package com.github.mgljava.chapter2

import scala.math.sqrt

object Chapter2Test {
  def main(args: Array[String]): Unit = {
    conditionExpress()
  }

  def conditionExpress(): Unit = {
    // 条件表达式
    val x = 3
    println(if (x > 0) 1 else 2)

    val r = if (x > 2) 2 else 3
    println(r)
    var y = 0
    if (x > 3) y = 3 else y = 2
    println(y)

    val r2 = if (x > 12) "hello" else 3
    println(r2)

    // 块表达式和赋值
    val distance = {
      val x1 = 1
      val x2 = 2
      val y1 = 1
      val y2 = 2

      val dx = x1 - x2
      val dy = y1 - y2
      sqrt(dx * dx + dy * dy) // {} 块的取值为最后一个表达式
    }
    println(distance)

    val result = {
      var n = 10
      n -= 1 // 如果最后一行语句为赋值动作，那么不返回值
    }
    println("result: " + result) // result: ()

    // 输入输出
    // val name = readLine("Your Name is : ")
    // print("Your Age is : ")
    // val age = readInt()
    printf("hello my name is %s, my age is %d", "name", 20)

    println()
    // 循环
    var n = 10
    while (n > 0) {
      print(n + ", ")
      n -= 1
    }
    println()

    for (i <- 1 to 10) {
      print(i + ", ")
    }
    println()

    // 遍历字符序列
    var sum = 0
    for (ch <- "Hello") {
      sum += ch
    }
    println("sum: " + sum)

    // 高级for循环
    for (i <- 1 to 3; j <- 1 to 3)
      print((10 * i) + j + " ") // 11 12 13 21 22 23 31 32 33 相当于双层for循环

    println()
    for (i <- 1 to 3; j <- 1 to 3 if i != j)
      print((10 * i) + j + " ") // 12 13 21 23 31 32
    println()

    // for 推导式
    val ints = for (i <- 1 to 10) yield i % 3
    println("ints: " + ints) // ints: Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)

    val strs = for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
    println("strs: " + strs)
    /*val strs2 = for(c <- "hello"; i <- 1 until  2) {
      println(c)
      println((c + i).toChar)
    }*/

  }
}
