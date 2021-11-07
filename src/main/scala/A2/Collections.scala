package A2

import A1.Base.Person
import io.circe
import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder
import io.circe.jawn.decode
object Collections extends App {
  val json = """
{
  "id" : 6,
  "name" : "Piter",
  "rates": [ 4, 5, 6 ]
}
"""
  implicit val decoderPerson: Decoder[Person] = deriveDecoder
  val either: Either[circe.Error, Person] = decode(json)
  println(s"either.isLeft = ${either.isLeft}")
  val result = either.map(pers => s"Your person is ${pers.name}. He make strange rates ${pers.rates.mkString(",")}")
  result.foreach(println)
}
