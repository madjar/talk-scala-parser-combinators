import net.compiletoi.CSVParser
import org.scalatest._



class Step2Spec extends Spec {
  val someCSV =
    """date;description;trainer
      |8 janv. 2016;Comment bien démarrer un projet d'entreprise avec Angular.;Fabien
      |15 janv. 2016;Présentation de la CI;Ludo
      |21 janv. 2016;R, où comprendre avec quoi travaillent nos amis les Data Scientists;Alban
      |28 janv. 2016;Is my cat a monad?;Georges""".stripMargin


  "CSVParser" should "parse a cell" in {
    assertParse(
      CSVParser.parse(CSVParser.cell, "hello world"),
      "hello world")
  }

  it should "parse a line" in {
    assertParse(
      CSVParser.parse(CSVParser.line, "hello;world"),
      List("hello", "world"))
  }

  it should "parse some csv" in {
    val result = CSVParser(someCSV).get
    result.length shouldBe 5
    result(4)(1) shouldBe "Is my cat a monad?"
  }
}
