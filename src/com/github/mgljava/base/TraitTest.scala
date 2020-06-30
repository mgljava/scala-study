package com.github.mgljava.base

/**
 * trait定义的类型与Object一样，不允许传参
 */
trait Speak {
  def speak(name: String): Unit = {
    println(name + " is speaking...")
  }
}

trait Listen {
  def listen(name: String): Unit = {
    println(name + " is listening...")
  }
}

// 允许多继承，第一个继承用extends，后面所有的继承都使用with
class Person1() extends Speak with Listen {

}

object TraitTest {

  def main(args: Array[String]): Unit = {
    val person = new Person1()
    person.speak("张三")
    person.listen("李四")
  }
}
