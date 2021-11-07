package L2

object SelfTypeCake extends App {

  trait User {
    def username: String
  }

  trait Tweeter {
    a: User =>
    def tweet(tweetText: String): Unit = println(s"@$username $tweetText")
  }

  class TweeterExample extends Tweeter with User {
    override def username: String = "JonnyDepth"
  }

  val actor = new TweeterExample
  actor.tweet("Hello guys")

}
