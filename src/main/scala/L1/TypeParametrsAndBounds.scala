package L1

import A2.Inheritance.{Animal, Lion}

import scala.reflect.{ClassTag, classTag}

object TypeParametrsAndBounds extends App {
  class Box[T <: Animal](val state: T)

  case class Wolf()

  val box1 = new Box(new Lion)

  //val box2 = new Box(Wolf())
  trait Eatable

  class Vegetable extends Eatable

  class Meat extends Eatable

  class Potato extends Vegetable

  class Beef extends Meat

  class Orange extends Eatable

  class Stew[A >: Potato]

  class BBQ[A >: Beef]

  class Juice[A >: Orange]

  val stew = new Stew[Vegetable]
  val BBQ = new BBQ[Meat]
  //val juice = new Juice[Potato] // error

  def f[A <% Ordered[A]](a: A, b: A): A = if (a > b) a else b

  def g[A: ClassTag](): Unit = {
    def runtimeClass: Class[_] = classTag[A].runtimeClass
    lazy val name = runtimeClass.getSimpleName
    lazy val fields = runtimeClass.getDeclaredFields.map(_.getName)
    println(s"The class name is $name. Fields are ${fields.mkString(",")}")
  }
  g[String]()
  g[Wolf]()
}
