package com.github.mgljava.base

object CollectionsTest {

  def main(args: Array[String]): Unit = {
    /**
     * Array
     */
    val array = Array[Int](1, 2, 3, 4)
    array.foreach(println(_))

    for (elem <- array) {
      println("elem : " + elem)
    }

    val arr = new Array[String](3)
    arr(0) = "a"
    arr(1) = "b"
    arr(2) = "c"
    arr.foreach(println)

    /**
     * List：有序，可以重复
     * map: 一对一
     * flatmap：一对多
     */
    println("-----list------")
    val list = List[Int](1, 2, 3, 4)
    list.foreach(println)

    val result = List("hello world", "hello hive", "hello hadoop")
    println(result)
    val list1 = result.map(item => {
      item.split(" ")
    })
    list1.foreach(list => {
      println("**********")
      list.foreach(println(_))
    })

    println("==============")
    val list2 = result.flatMap(s => {
      s.split(" ")
    })
    println(list2)
    list2.foreach(s => {
      println(s)
    })

    /**
     * Set: 无序，不重复
     */
    println("------set----------")
    val sets = Set[Int](1, 2, 3, 4, 5, 4)
    sets.foreach(item => {
      println(item)
    })

    /**
     * Map，与Java的Map一致
     */
    println("------map-----")
    val maps = Map(1 -> "a", 2 -> "b", (3, "c"), (3, "d"))
    maps.foreach(println(_))
    // 取值
    val value = maps.get(2).getOrElse("xxxx")
    println(value)

    val keys = maps.keys
    for (key <- keys) {
      println(key)
    }
    val values = maps.values
    for (value <- values) {
      println(value)
    }

    /**
     * tuple 元组
     * tuple 最多支持22个元素
     */
    println("------tuple-------")
    val tuple = Tuple5(1, 2, 'c', "aa", 20L)
    val tuple1 = Tuple2("hello", "world")
    println(tuple)
    println(tuple1)
    // 遍历1 tuple
    val iterator = tuple.productIterator
    iterator.foreach(println)
    // 遍历2 tuple
    val iterator1 = tuple.productIterator
    while (iterator1.hasNext) {
      println(iterator1.next())
    }
  }
}
