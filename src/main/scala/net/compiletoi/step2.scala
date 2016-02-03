package net.compiletoi

import scala.util.parsing.combinator.RegexParsers


object CSVParser extends RegexParsers {
  def cell: Parser[String] = ???
  def line = ???
  def csv = ???

  def apply(input: String): ParseResult[List[List[String]]] = parseAll(csv, input)
  override def skipWhitespace = false
}
