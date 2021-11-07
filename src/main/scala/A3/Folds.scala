package A3
object Folds extends App {
  def operator(ac: List[String],p: Person): List[String] = {
    val title = p.sex match {
      case 'f' => "Mrs"
      case 'm' => "Mr"
    }
    ac :+ s"$title,${p.name},${p.age}"
  }
  case class Person(name: String, age: Int, sex: Char)
  val persons = List(Person("Bob",13,'m'),Person("Jane",15,'f'),Person("Bill",17,'m'))
  persons.foldLeft(List[String]())((ac,p) => operator(ac,p)).foreach(println)
  val lst = LazyList.from(1).take(100).foldLeft(0)((ac, el) => ac + el / 5)
  persons.foldRight(List[String]())((p,ac) => operator(ac,p)).foreach(println)
  println(s"Normalize sum is $lst")
  //fold only for monoid types
}
