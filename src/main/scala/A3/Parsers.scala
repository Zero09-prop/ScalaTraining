package A3

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

object Parsers {
  class ExprParser extends RegexParsers {
    val number: Regex = "[1-9][0-9]+".r

    def expr: Parser[Any] = number ~ opt(operator ~ expr)

    def operator: Parser[Any] = "+" | "-" | "*" | "/"
  }
  def main(args: Array[String]): Unit = {
    val parser = new ExprParser
    val result = parser.parseAll(parser.expr, "9*8+21/7")
    println(result.get)
  }
}
