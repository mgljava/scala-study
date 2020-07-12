package com.github.mgljava.chapter1

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
  }
}
