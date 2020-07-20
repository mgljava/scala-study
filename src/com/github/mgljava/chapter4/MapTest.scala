package com.github.mgljava.chapter4

import scala.collection.mutable

/**
 * 映射：Map
 * 1. 映射是对偶的集合，对偶就是两个值构成的组
 * 3. 映射这种数据结构是一种将键映射到值的函数
 */
object MapTest {
  def main(args: Array[String]): Unit = {

    /**
     * 创建映射
     * 1. 操作符 -> 用来创建映射
     * 2. (key, value) 用来创建映射
     */
    // 构造一个不可变的Map
    val scores0 = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    val scores1 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))

    // 构造一个可变的Map
    val scores2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

    // 构造一个空的映射
    val scores3 = new mutable.HashMap[String, Int]()

    /**
     * 获取映射中的值
     */
    println("--------获取映射中的值------------")
    val value = scores0("Cindy")
    println(value)
    /*val value2 = scores0("zhangsan") // java.util.NoSuchElementException: key not found: zhangsan  报错
    println(value2)*/
    // 先通过 contains 判断指定的键是否存在
    val zhangsanScores = if (scores0.contains("zhangsan")) scores0("zhangsan") else 0
    println(zhangsanScores)

    // 快捷写法
    val bobScores = scores0.getOrElse("zhang", 10)
    println(bobScores)

    /**
     * 更新映射的值
     * 1. 必须保证映射是可变的
     */
    println("--------更新映射的值------------")
    scores2("Cindy") = 10 // 更新
    scores2("Fred") = 7 // 如果原始key不存在，那就新增
    println("scores2(\"Cindy\") : " + scores2("Cindy"))
    println("scores2(\"Fred\") : " + scores2("Fred"))

    // 使用 += 操作添加映射
    scores2 += ("Zhangsan" -> 12, "lisi" -> 20)
    println("+= : " + scores2)

    // 使用 -= 操作移除映射
    scores2 -= "Zhangsan"
    println("-= : " + scores2)

    /**
     * 迭代映射
     */
    println("----------迭代映射-----------")
    for((key, value) <- scores2) {
      println(s"key: $key, value : $value")
    }

    scores2.keySet // key集合
    scores2.values // value集合
    // 如果要交换键值，可以采用yield, 如果原来的value相同，反转后的key则只会保留一条数据，后面的会覆盖前面的
    val reverseMap = for ((k, v) <- scores2) yield (v, k)
    for((key, value) <- reverseMap) {
      println(s"reverseMapkey: $key, reverseMapvalue : $value")
    }

    /**
     * 有序的映射
     * 默认按照key的字典顺序排序
     */
    println("-------有序的映射---------")
    val names = scala.collection.immutable.SortedMap(("zhangsan", 10), ("lisi", 20), ("wangwu", 28))
    println(names)
  }
}
