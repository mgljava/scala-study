package com.github.mgljava.chapter1

import scala.math._

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
  }
}
