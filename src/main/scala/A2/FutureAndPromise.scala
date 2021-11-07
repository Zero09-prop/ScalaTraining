package A2

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, Promise}
import scala.language.postfixOps

object FutureAndPromise extends App {
  def first[T](f: Future[T], g: Future[T]): Future[T] = {
    val p = Promise[T]

    f foreach { x =>
      p.trySuccess(x)
    }

    g foreach { x =>
      p.trySuccess(x)
    }

    p.future
  }
  val future = Future {
    Thread.sleep(2000)
    9 + 8.90
  }
  val promise = Promise
  println(s"future first query = ${future}")
  val future2 = future.map(_ * 3)
  Await.result(future, 3 seconds)
  println(s"future second query = ${future}")
  println(s"future2 = $future2")
  println(s"first(future,future2) = ${first(future, future2)}")
}
