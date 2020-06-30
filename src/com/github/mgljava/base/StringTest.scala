package com.github.mgljava.base

object StringTest {
  def main(args: Array[String]): Unit = {

    val s = "hello"
    val s1 = "Hello"

    println(s.equals(s1))
    println(s.equalsIgnoreCase(s1))

    val builder = new StringBuilder
    builder.append("welcome")
    builder.append("\t")
    builder.append("hello")
    println(builder)
  }
}
