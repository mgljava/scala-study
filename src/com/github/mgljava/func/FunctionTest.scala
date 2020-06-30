package com.github.mgljava.func

import java.util.Date

object FunctionTest {

  def main(args: Array[String]): Unit = {

    /**
     * 1.方法定义
     *
     *  1.方法定义用def,函数的参数 要写类型，不写类型不可以。
     *  2.函数的返回值类型可以不写，会自动推断
     *  3.scala会将函数体中最后一行计算的结果当做返回值返回
     *  4.可以写“return”,写了return要显式的声明方法体的返回类型。
     *  5.定义方法时，如果不写“=”，那么无论方法体中最后一行计算的结果返回是什么，都会被丢弃，返回Unit
     *  6.方法体可以一行搞定，那么方法体的“{... ...} ” 可以省略不写
     */
    def max(a: Int, b: Int): Int = {
      if (a > b) {
        a
      } else {
        b
      }
    }

    println(max(90, 20))

    // 如果只有一行代码，可以不写花括号
    def max1(a: Int, b: Int) = if (a > b) a else b

    println(max1(200, 199))

    /**
     * 2.递归函数: 递归函数要显式的声明返回类型
     */
    def recursion(num: Int): Int = {
      if (num == 1) {
        num
      } else {
        num * recursion(num - 1)
      }
    }

    println(recursion(5))

    // 斐波拉契数列
    def fibonacci(num: Int): Int = {
      if (num == 1 || num == 2) {
        1
      } else {
        fibonacci(num - 1) + fibonacci(num - 2)
      }
    }

    println(fibonacci(8)) // 21

    /**
     * 3.函数的参数有默认值
     */

    def funDefault(x: Int = 100, y: Int = 200): Int = {
      x + y
    }

    println(funDefault(y = 80))

    /**
     * 4.可变长参数的函数
     */
    def varFunc(s: String*): Unit = {
      s.foreach(println)
    }

    varFunc("12", "32", "23")

    /**
     * 5.匿名函数
     *   1."=>"就是匿名函数
     *   2.匿名函数调用要赋值给一个变量，调用直接调用这个变量就可以
     *   3.匿名函数不能显式的写函数返回类型
     */
    val anonymousFunc: (Int, Int) => Int = (x: Int, y: Int) => {
      x + y
    }
    println(anonymousFunc(10, 20))
    println("-----------")

    /**
     * 6.偏应用函数
     *
     * 偏应用函数是一个表达式，将方法中不变的参数写上，变化的参数使用“_”表示，下次直接调用这个偏应用表达式直接传入变化的参数就可以
     */
    def showLog(date: Date, log: String) = {
      println("date is " + date + ",log is " + log)
    }

    val date = new Date()
    showLog(date, "a")
    showLog(date, "b")
    showLog(date, "c")

    val fun = showLog(date, _: String)

    fun("aaa")
    fun("bbb")
    fun("ccc")
    println("-----------")

    /**
     * 7.嵌套函数
     */
    def outFunc(x: Int): Int = {
      def inFunc(num: Int): Int = {
        if (num == 1) {
          1
        } else {
          num * inFunc(num - 1)
        }
      }

      inFunc(x)
    }

    println(outFunc(10))

    /**
     * 8.高阶函数
     *  1.函数的参数是函数
     *  2.函数的返回是函数  --函数的返回是函数时，要显式声明函数的返回类型
     *  3.函数的参数和返回都是函数
     */
    //函数的参数是函数
    def higherFunc1(f: (Int, Int) => Int, s: String): String = {
      val result = f(100, 200)
      result + "~" + s
    }

    val result = higherFunc1((a: Int, b: Int) => {
      a + b
    }, "Hello")
    println(result)

    //函数的返回是函数
    def higherFunc2(a: Int, b: Int): (String, String) => String = {
      val result = a + b;
      def fun(s: String, s1: String) = {
        s + "@" + s1 + "#" + result
      }

      return fun
    }

    val response = higherFunc2(10, 20)("hello", "welcome")
    println(response)

    //函数的参数和返回都是函数
    def higherFunc3(f: (Int, Int) => Int): (String, String) => String = {
      val result = f(8, 9)

      def fun(s1: String, s2: String): String = {
        s1 + "@" + s2 + "$" + result
      }

      return fun
    }

    val response2 = higherFunc3((a: Int, b: Int) => a + b)("hadoop", "hive")
    println(response2)

    /**
     * 9.柯里化函数
     * 柯里化函数就是高阶函数的简化版
     */
    def curriedFunc(a: Int, b: Int)(c: Int, d: Int): Int = {
      a + b + c + d
    }

    println(curriedFunc(1, 2)(39, 4))
  }
}















