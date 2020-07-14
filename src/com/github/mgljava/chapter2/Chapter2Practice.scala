package com.github.mgljava.chapter2

object Chapter2Practice {

  def main(args: Array[String]): Unit = {
    // println(q1(number = 0))
    q4()
  }

  def q1(number: Int): Int = {
    if (number > 0) 1 else if (number == 0) 0 else -1
  }

  def q4(): Unit = {
    var i = 10
    while (i > 0) {
      println(i)
      i -= 1
    }
  }
}
