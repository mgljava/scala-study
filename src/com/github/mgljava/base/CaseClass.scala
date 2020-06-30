package com.github.mgljava.base

/**
 * 样例类
 * 如果采用case来修饰，那么自动为类的变量添加 getter、setter、equals、toString 等
 * 如果参数采用 val来修饰，那么只会有getter 和 setter方法
 */
case class Human(var name: String, age: Int)

object CaseClass {
  def main(args: Array[String]): Unit = {
    val h1 = Human("zhangsan", 12)
    val h2 = Human("zhangsan", 12)
    println(h1.equals(h2)) // 比较的是内存地址
  }
}
