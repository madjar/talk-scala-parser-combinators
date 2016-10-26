package net.compiletoi

import scala.util.parsing.combinator.RegexParsers

sealed trait Expression
case class Literal(v: Integer) extends Expression
case class Sum(left: Expression, right: Expression) extends Expression
case class Product(left: Expression, right: Expression) extends Expression

object ExpressionParser extends RegexParsers {
  // example: "42"
  def lit = ???

  // example: "(1 + 2)" or "((1 + 2) + 3)"
  def sum = ???

  // example: "(1 * 2)" or "((1 + 2) * 3)"
  def product = ???

  // example: "(12 + (1 * 2))"
  def expr: Parser[Expression] = ???


  def apply(input: String): ParseResult[Expression] = parseAll(expr, input)
}
