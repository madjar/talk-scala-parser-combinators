package net.compiletoi

import scala.util.parsing.combinator.RegexParsers

sealed trait Expression
case class Literal(v: Integer) extends Expression
case class Sum(left: Expression, right: Expression) extends Expression
case class Product(left: Expression, right: Expression) extends Expression

object ExpressionParser extends RegexParsers {
  // example: "42"
  def lit = """\d+""".r ^^ {i => Literal(i.toInt)}

  // example: "(1 + 2)" or "((1 + 2) + 3)"
  def sum = "(" ~> (expr <~ "+") ~ expr <~ ")" ^^ { case l ~ r => Sum(l, r)}

  // example: "(1 * 2)" or "((1 + 2) * 3)"
  def product = "(" ~> (expr <~ "*") ~ expr <~ ")" ^^ { case l ~ r => Product(l, r)}

  // example: "(12 + (1 * 2))"
  def expr: Parser[Expression] = lit | sum | product


  def apply(input: String): ParseResult[Expression] = parseAll(expr, input)
}
