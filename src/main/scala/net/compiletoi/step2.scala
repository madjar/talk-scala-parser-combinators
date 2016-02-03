package net.compiletoi

import scala.util.parsing.combinator.RegexParsers


object CSVParser extends RegexParsers {
  // example: "hello world"
  def cell: Parser[String] = "[^\n;]+".r

  // example "hello;world"
  def line = repsep(cell, ";")

  def csv = repsep(line, "\n")

  def apply(input: String): ParseResult[List[List[String]]] = parseAll(csv, input)
  override def skipWhitespace = false
}
