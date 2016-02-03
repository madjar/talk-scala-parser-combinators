package net.compiletoi

import scala.util.parsing.combinator.RegexParsers

sealed trait Expression
case class Literal(v: Integer) extends Expression
case class Sum(left: Expression, right: Expression) extends Expression
case class Product(left: Expression, right: Expression) extends Expression

object ExpressionParser extends RegexParsers {
  def lit = ???
  def sum = ???
  def product = ???
  def expr: Parser[Expression] = ???


  def apply(input: String): ParseResult[Expression] = parseAll(expr, input)
}
