import net.compiletoi.Greetings
import org.scalatest._



class Step1Spec extends Spec {
  "Greetings" should "parse 'Hello World'" in {
    assertParse(Greetings("Hello World"), "World")
  }

  it should "parse 'Hello Georges" in {
    assertParse(Greetings("Hello Georges"), "Georges")
  }

  it should "not parse 'Goodbye world'" in {
    Greetings("Goodbye World").successful shouldBe false
  }
}
