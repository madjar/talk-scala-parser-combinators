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

  def str = "\"" ~> """[^"]*""".r <~"\"" ^^ JStr
  def num = """\d+(\.\d*)?""".r ^^ (d => JNum(d.toDouble))
  def bool = "true" ^^^ JBool(true) | "false" ^^^ JBool(false)
  def null_ = "null" ^^^ JNull
  def array = "[" ~> repsep(json, ",") <~ "]" ^^ JArray
  def objItem = (str <~ ":") ~ json ^^ { case k ~ v => (k.v, v)}
  def object_ =  "{" ~> repsep(objItem, ",") <~ "}" ^^ (l => JObject(l.toMap))

  def json: Parser[JSON] = str | num | bool | null_ | array | object_


  def apply(input: String): ParseResult[JSON] = parseAll(json, input)
}
