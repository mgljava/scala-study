package com.github.mgljava.chapter4

/**
 * 元组：元组是不同类型的值的聚集
 * 1. 对偶是元组最简单的形态
 * 2. 元组的值时通过将单个的值包含在圆括号中构成的 (1, 3.14, "name"), 类型为 (Int, Double, String)
 * 3. 元组的组元从下表1开始，通过 _1,_2,_3 等方式来访问或者使用 tuple _2 空格来访问
 */
object TupleTest {
  def main(args: Array[String]): Unit = {
    // 定义元组
    val tuple3: (Int, Double, String) = (1, 3.14, "Zhangsan")

    // 访问元组
    println(tuple3._1)
    println(tuple3._2)
    println(tuple3._3)
    println(tuple3 _2)

    // 拉链操作, 只会映射相同的个数的元素
    println("-----拉链操作--------")
    val symbols = Array("<", "-", ">")
    val counts = Array(2, 10, 2)
    val pairs = symbols.zip(counts)
    for (pair <- pairs) {
      println(pair)
    }

    val keys = Array("zhangsan", "lisi", "wangwu", "zhaoliu")
    val values = Array(29, 89, 99, 90)
    val names = keys.zip(values).toMap
    for(name <- names) {
      println(name)
    }
  }
}
