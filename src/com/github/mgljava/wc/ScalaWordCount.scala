package com.github.mgljava.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object ScalaWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("ScalaWordCount")
    val sc = new SparkContext(conf)
    val lines: RDD[String] = sc.textFile("./words")
    val words: RDD[String] = lines.flatMap(line => {
      line.split(" ")
    })

    val pairWords: RDD[(String, Int)] = words.map(word => {
      Tuple2(word, 1)
    })

    /**
     * reduceByKey: 先分组，后对每一组内的key对应的value聚合
     */
    val result: RDD[(String, Int)] = pairWords.reduceByKey((v1: Int, v2: Int) => {
      v1 + v2
    })
    result.foreach(tuple => {
      println(tuple)
    })

    sc.stop()

    // 简化版写法
    /*
    val conf = new SparkConf().setMaster("local").setAppName("ScalaWordCount")
    new SparkContext(conf).textFile("./words").flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).foreach(println)

     */
  }
}