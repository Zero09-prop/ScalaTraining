package A2

object Inheritance extends App {

  class Animal
  class Dog extends Animal
  class Cat extends Animal
  class Spaniel extends Dog
  class Lion extends Cat

  val containerAnimal = List(new Dog, new Cat, new Spaniel, new Lion)
  containerAnimal.foreach(println)
}
