package A3

object TypeProjection extends App {
  class Foo {
    class Bar
  }

  val foo1 = new Foo
  val bar1 = new foo1.Bar
  val foo2 = new Foo
  val bar2 = new foo2.Bar

  val bar: Foo#Bar = if (???) bar1 else bar2

  abstract class For {
    type Bar
    def process(x: Bar): Bar
  }
  class ForInt extends For {
    type Bar = Int
    def process(x: Bar): Bar = x + 1
  }
  class ForString extends For {
    type Bar = String
    def process(x: Bar): Bar = s"Hello $x!"
  }

  val for1 = new ForInt
  val for2 = new ForString

  def test(foo: For)(x: foo.Bar): foo.Bar = {
    val res = foo.process(x)
    println(s"Result of process is: $res")
    res
  }
  val f1 = test(for1)(42)
  val f2 = test(for2)("World1")

  val ans: For#Bar = if (???) f1 else f2


}
