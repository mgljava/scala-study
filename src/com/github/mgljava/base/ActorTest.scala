package com.github.mgljava.base

import scala.actors.Actor

/**
 * Actor 是通信模型，Spark底层节点之间通信就是使用的 Akka，Akka是通信模型，Akka的底层就是Actor实现的
 *
 * Actor相当于我们理解的线程（Thread）。
 *
 * Actor 异步通信
 */

class MyActor extends Actor {
  def act(): Unit = {
    while (true) { // 一直等待接收消息
      receive({
        case s: String => println("value is " + s)
        case _ =>
          println("default")
      })
    }
  }
}

object ActorTest {

  def main(args: Array[String]): Unit = {
    val actor = new MyActor()
    actor.start()
    // actor ! "hello" // 给当前的 actor 发送了消息，内容为hello
    actor ! 22
  }
}
