package net.compiletoi

import scala.util.parsing.combinator.RegexParsers


object Greetings extends RegexParsers {
  // example : "Hello World" or "Hello Parsers"
  def hello = "Hello" ~> """\w+""".r

  def apply(input: String): ParseResult[String] = parseAll(hello, input)
}
