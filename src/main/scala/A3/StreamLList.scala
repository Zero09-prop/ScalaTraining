package A3

object StreamLList extends App {
  def fib(a: Int, b: Int = 1): Stream[Int] =
    a #:: fib(b, a + b)
  val str = fib(0).take(7)
  println(str.mkString(","))

  val num = LazyList.from(0).partition(_ % 2 == 0)
  println(num._1.take(10).mkString(","))
  println(num._2.take(10).mkString(","))

  println(LazyList.from(0, 2).map(x => s"Hello number $x").take(6).mkString("\n"))
}
