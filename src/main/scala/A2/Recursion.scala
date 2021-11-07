package A2

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): BigInt =
    if (n == 1)
      1
    else
      n * factorial(n - 1)

  println(s"factorial(100) = ${factorial(100)}")

  //tail-recursion
  @tailrec
  def factorialTail(n: Int, acc: BigInt = 1): BigInt = {
    if (n == 0)
      acc
    else
      factorialTail(n - 1, acc * n)
  }

  println(s"factorialTail(100) = ${factorialTail(100)}")
}
