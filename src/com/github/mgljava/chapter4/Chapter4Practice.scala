package com.github.mgljava.chapter4

object Chapter4Practice {
  def main(args: Array[String]): Unit = {
    q1()
    println("hello".zip("world")) // Vector((h,w), (e,o), (l,r), (l,l), (o,d))
  }

  def q1(): Unit = {
    val equipment = Map("landun" -> 10, "pobai" -> 20, "wujin" -> 30)
    val result = for ((k, v) <- equipment) yield (k, v * 0.9)
    for (i <- result) {
      println(i)
    }
  }
}
