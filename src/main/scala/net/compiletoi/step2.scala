package net.compiletoi

import scala.util.parsing.combinator.RegexParsers


object CSVParser extends RegexParsers {
  // example: "hello world"
  def cell: Parser[String] = ???

  // example "hello;world"
  def line = ???

  def csv = ???

  def apply(input: String): ParseResult[List[List[String]]] = parseAll(csv, input)
  override def skipWhitespace = false
}
