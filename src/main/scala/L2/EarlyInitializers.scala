package L2

object EarlyInitializers extends App {
  abstract class X {
    val name: String
    val nameSize: Int = name.length
  }
  class Y extends { val name = "Pattern class" } with X
  val y = new Y
  println(s"The name is '${y.name}'. The name size is ${y.nameSize}")

  class MyBoxCo[+T](val element: T)
  class MyBoxContr[-T]
  class MyBoxInv[T](val element: T)
  trait Fruit
  class Orange extends Fruit
  class Apple extends Fruit
  val boxCo: MyBoxCo[Fruit] = new MyBoxCo[Orange](new Orange)
  val boxContr: MyBoxContr[Apple] = new MyBoxContr[Fruit]
  val boxInv = new MyBoxInv[Fruit](new Orange)
}
