package A1

import cats.implicits._
object Base extends App {

  //simple closure
  val g: Double = 9.8

  val GravityForce = (m: Double) => m * g

  println(s"GravityForce(5) = ${GravityForce(5)}")
  println(s"GravityForce(10) = ${GravityForce(10)}")

  //collections

  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val set = Set("a", "b", "c", "d", "e")
  val map = Map(1 -> "Misha", 2 -> "Semen", 3 -> "Victor")

  println(s"list.map(_ * 2) = ${list map(_ * 2) }")
  println(s"set.filter() = ${set filter(_.codePointAt(0) % 2 != 0)}")
  println(s"list.scan(0)(_ + _) = ${list.scan(0)(_ + _)}")
  println(s"map.mkString(\"[\",\", \",\"]\") =  ${map mkString("[",", ","]")}")

  //Option and Pattern Matching
  val listMeanings: List[Any] = List(1,2,"a","b",'c',9.0,new RuntimeException("Wrong program"),null)

  listMeanings map(Option(_)) foreach {
    case Some(value) => println(s"The meaning is: $value")
    case None => println("For that expression meaning is lost")
  }

  //for-comprehensions
  case class Person(id: Int,name: String, rates: List[Option[Int]])

  val persons = Vector(Person(1,"Paul",List(1.some,None,3.some)),Person(2,"Misha",List(5.some)),Person(3,"Steve",List(6.some,7.some)))

  val result = for {
    person <- persons
    rate <- person.rates.sequence
  } yield rate

  println("\nResult for-comprehensions")
  result foreach println


}
