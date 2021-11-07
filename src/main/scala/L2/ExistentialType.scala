package L2

import scala.language.existentials

object ExistentialType extends App {
  trait Existential {
    type Inner
    val value: Inner
  }

  case class MkEx[A](value: A) extends Existential { type Inner = A }

  val a = MkEx("hello world"): Existential
  val b = MkEx(12345): Existential
  a match {
    case MkEx(string) => println(string)
  }
}
