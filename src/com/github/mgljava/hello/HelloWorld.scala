package com.github.mgljava.hello

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
    welcome()
    println(calc())
  }

  def welcome(): Unit = {
    println("welcome")
  }

  def calc(): Int = {
    val i = 2 * 2
    if(i == 4) {
      3
    } else {
      5
    }
  }
}
