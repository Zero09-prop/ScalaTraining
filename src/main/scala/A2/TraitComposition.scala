package A2
trait Log {
  def log(msg: String): Unit
}
trait ConsoleLog extends Log {
  override def log(msg: String): Unit = println(s"Console output: $msg")
}
trait FileLog extends Log {
  override def log(msg: String): Unit = println(s"File output: $msg")
}
class Logger1 extends ConsoleLog with FileLog
class Logger2 extends FileLog with ConsoleLog

object TraitComposition extends App {
  val logger1 = new Logger1
  logger1.log("Hi")

  val logger2 = new Logger2
  logger2.log("Bye")
}
