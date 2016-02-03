import net.compiletoi.{Product, Sum, Literal, ExpressionParser}

class Step3Spec extends Spec {
  "ExpressionParser" should "parse an Int" in {
    assertParse(
      ExpressionParser.parse(ExpressionParser.lit, "42"),
      Literal(42))
  }

  it should "parse a Sum" in {
    assertParse(
      ExpressionParser.parse(ExpressionParser.sum, "(1 + 2)"),
      Sum(Literal(1), Literal(2)))
  }

  it should "parse a Product" in {
    assertParse(
      ExpressionParser.parse(ExpressionParser.product, "(1 * 2)"),
      Product(Literal(1), Literal(2)))
  }

  it should "parse a complex expression" in {
    assertParse(
      ExpressionParser("(12 + (1 * 2))"),
      Sum(Literal(12), Product(Literal(1), Literal(2))))
  }
}
