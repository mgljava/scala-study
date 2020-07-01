package com.github.mgljava.wc

import org.apache.spark.{SparkConf, SparkContext}

object ComputeWord {
  def main(args: Array[String]): Unit = {
    val logFile = "./words"
    val conf = new SparkConf().setAppName("Test").setMaster("local")
    val sc = new SparkContext(conf)
    val files = sc.textFile(logFile).cache()
    val numAs = files.filter(line => line.contains("Spark")).count()
    val numBs = files.filter(line => line.contains("DAGScheduler")).count()
    println(s"Lines with Spark: $numAs, Lines with DAGScheduler: $numBs")
    sc.stop()
  }
}
