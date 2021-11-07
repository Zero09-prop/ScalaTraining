package L1

object Currying extends App {
  def sum(x: Int, y: Int): Int = x + y
  def sum1(x: Int): Int => Int = (y: Int) => x + y
  def sum3: Int => Int => Int = (x: Int) => (y: Int) => x + y
  def sum4(x: Int)(y: Int): Int = x + y

  val +* : Int => Int = sum4(2)
  println(+*(5))
  val flag = false
  def access(pred: => Boolean): Unit =
    if (flag && !pred)
      throw new AssertionError("By-name parametr")
  def same(value: Boolean): Unit =
    if (flag && !value)
      throw new AssertionError("Parametr")
  access(5 / 0 == 0)
  same(5 / 0 == 0)

}
