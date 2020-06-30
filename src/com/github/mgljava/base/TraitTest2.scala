package com.github.mgljava.base

trait IsEqual {
  // 可以不实现
  def isEqu(p: Any): Boolean

  // 可以有实现
  def isNotEqu(p: Any): Boolean = {
    !isEqu(p)
  }
}

class Point(xx: Int, yy: Int) extends IsEqual {
  val x: Int = xx
  val y: Int = yy

  override def isEqu(p: Any): Boolean = {
    p.isInstanceOf[Point] && p.asInstanceOf[Point].x == this.x
  }
}

object TraitTest2 {
  def main(args: Array[String]): Unit = {
    val p1 = new Point(1, 2)
    val p2 = new Point(2, 3)
    val result = p1.isNotEqu(p2)
    println(result)
  }
}
