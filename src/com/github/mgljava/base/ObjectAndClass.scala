package com.github.mgljava.base

/**
 * 1. scala中定义在object中的变量，方法都是静态的。object叫对象，相当于java中的单例对象
 * 2. scala中一行代码后可以写分号，也可以不写，会有分号推断机制。如果多行代码写在一行，那就需要写分号
 * 3. 定义变量用var，定义常量用val
 * 4. scala中的变量，类，对象，方法定义遵循驼峰命名。
 * 5. class 是scala中的类，类可以传参，传参就有了默认的构造函数。类中的属性默认就有getter、setter函数。
 */
class Person(paramName: String, paramAge: Int) {
  val name: String = paramName
  var age: Int = paramAge
  var gender = 'm';

  def this(yname: String, yage: Int, ygender: Char) {
    this(yname, yage)
    this.gender = ygender
  }

  def showHello() = {
    println("Name is Hello!")
  }
}

object LessonObjectAndClass {
  def main(args: Array[String]): Unit = {
    /**
     * 变量 常量
     * b: Long = 200L b冒号后面的Long是类型，可写可不写，如果不写可以自动推断类型
     */
    val b: Long = 200L
    var a = 100;
    a = 999
    println(a)

    println("------------------------")
    val person = new Person("张三", 20)
    println(person.name)
    println(person.age)
    person.age = 19
    println(person.age)
    println("------------------------")
    val person1 = new Person("李四", 30, 'f')
    println(person1.gender)

    for (i <- 1 until(10, 2)) {
      println(i)
    }

    for ( i<-1 to 10) {

    }
  }
}
