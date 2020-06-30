package com.github.mgljava.base

/**
 * 1. _=> 模式匹配值的默认匹配，放在最后
 * 2. 模式匹配不仅可以匹配值，还可以匹配类型
 * 3. 从上往下匹配，匹配上一个之后就不会继续往下匹配，自动 break
 */
object MatchTest {
  def main(args: Array[String]): Unit = {
    val tuple = (1, "hello", 'c', 1.1d, true)
    val iterator = tuple.productIterator
    while (iterator.hasNext) {
      val value = iterator.next()
      valid(value)
    }
  }

  def valid(value: Any): Unit = {
    value match {
      case i: Int => println(value + " type is INT")
      case s: String => println(value + " type is String")
      case d: Double => println(value + " type is Double")
      case c: Char => println(value + " type is Char")
      case b: Boolean => println(value + " type is Boolean")
      case _ => println("default...")
    }
  }
}
