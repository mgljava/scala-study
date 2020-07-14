package com.github.mgljava.chapter2

/**
 * scala函数
 * 1. 定义函数： 需要给出函数的名称、参数、函数体: def abs(x: Double) = if (x >= 0) x else -x
 * 2. 必须给出所有参数的类型
 * 3. 只要函数不是递归的，就不用指定函数的返回类型，scala编译器会通过表达式类型推断出返回类型
 * 4. 如果函数体有多个表达式，那么需要用代码块，块中最后一个表达式的值就是函数的返回值
 */
object FunctionTest {

  // 计算阶乘
  def fac(n: Int): Int = {
    var r = 1
    for (i <- 1 to n) r = r * i
    r
  }

  // 默认参数和带名参数
  def decorate(str: String, left: String = "[", right: String = "]"): String = {
    left + str + right
  }

  // 变长参数, 在类型后面加个 * 符号
  def sum(args: Int*): Int = {
    var result = 0
    for (arg <- args)
      result += arg
    result
  }

  // 递归
  def recursiveSum(args: Int*): Int = {
    println("head: " + args.head)
    println("tail: " + args.tail)
    2
  }

  def main(args: Array[String]): Unit = {
    println("fac: " + fac(4))
    println("decorate1: " + decorate("hello", "{{", "}}"))
    // 带名参数的调用,参数顺序不影响调用结果
    println("decorate2: " + decorate(str = "welcome", right = ">>", left = "<<"))
    println("sum1: " + sum(1, 2, 3))
    val sumResult = sum(8, 9, 19, 23, 123)
    println("sum2: " + sumResult)

    val sumResult2 = sum(1 to 5: _*)
    println("sumResult2: " + sumResult2)

    recursiveSum(1, 4, 5, 6, 8)
  }
}
