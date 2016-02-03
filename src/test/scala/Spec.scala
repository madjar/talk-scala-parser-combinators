import org.scalatest.{Matchers, FlatSpec}

import scala.util.parsing.combinator.Parsers


trait Spec extends FlatSpec with Matchers{
  def assertParse[T](result :Parsers#ParseResult[T], expected: T) = {
    if (result.successful) {
      result.get shouldBe expected
    } else {
      fail(result.toString)
    }
  }
}
