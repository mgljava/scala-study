package com.github.mgljava.base

import scala.actors.Actor

/**
 * Actor 与 Actor之间通信
 */

case class Message(actor: Actor, msg: String)

class MyActor1 extends Actor {
  def act(): Unit = {
    receive({
      case s: String => println("MyActor1 value is " + s)
      case a: Message =>
        println(a.msg)
        a.actor ! "hello"
      case _ =>
        println("default")
    })
  }
}

class MyActor2(actor: Actor) extends Actor {
  actor ! Message(this, "world")

  def act(): Unit = {
    receive({
      case s: String => println("MyActor2 value is " + s)
      case _ =>
        println("default")
    })
  }
}

object ActorTest2 {

  def main(args: Array[String]): Unit = {
    val actor1 = new MyActor1()
    val actor2 = new MyActor2(actor1)

    actor1.start()
    actor2.start()
  }
}
