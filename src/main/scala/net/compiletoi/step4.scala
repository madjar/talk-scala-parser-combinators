package net.compiletoi

import scala.util.parsing.combinator.RegexParsers

sealed trait JSON
case class JStr(v: String) extends JSON
case class JNum(v: Double) extends JSON
case class JBool(v: Boolean) extends JSON
case object JNull extends JSON
case class JArray(v: Seq[JSON]) extends JSON
case class JObject(v: Map[String, JSON]) extends JSON

object JSONParser extends RegexParsers {
  // for some inspiration, see http://www.json.org/

  def str = ???
  def num = ???
  def bool = ???
  def null_ = ???
  def array = ???
  def object_ = ???

  def json: Parser[JSON] = ???


  def apply(input: String): ParseResult[JSON] = parseAll(json, input)
}
