import net.compiletoi._

class Step4Spec extends Spec {
  "JSONParser" should "parse a str" in {
    assertParse(
      JSONParser.parse(JSONParser.str, "\"hello\""),
      JStr("hello"))
  }

  it should "parse a num" in {
    assertParse(
      JSONParser.parse(JSONParser.num, "3.14"),
      JNum(3.14))
  }

  it should "parse a true" in {
    assertParse(
      JSONParser.parse(JSONParser.bool, "true"),
      JBool(true))
  }

  it should "parse a false" in {
    assertParse(
      JSONParser.parse(JSONParser.bool, "false"),
      JBool(false))
  }

  it should "parse a null" in {
    assertParse(
      JSONParser.parse(JSONParser.null_, "null"),
      JNull)
  }

  it should "parse an array" in {
    assertParse(
      JSONParser.parse(JSONParser.array, "[1, 2]"),
      JArray(Seq(JNum(1), JNum(2))))
  }

  it should "parse an object" in {
    assertParse(
      JSONParser.parse(JSONParser.object_, "{\"one\": 1, \"two\": 2}"),
      JObject(Map("one" -> JNum(1), "two" -> JNum(2))))
  }

  it should "parse a complex object" in {
    val input = """{
                  |    "menu": {
                  |        "id": "file",
                  |        "value": "File",
                  |        "popup": {
                  |            "menuitem": [
                  |                { "value": "New", "onclick": "CreateNewDoc()" },
                  |                { "value": "Open", "onclick": "OpenDoc()" },
                  |                { "value": "Close", "onclick": "CloseDoc()" }
                  |            ]
                  |        }
                  |    }
                  |}""".stripMargin
    assertParse(
      JSONParser(input),
      JObject(Map("menu" -> JObject(Map("id" -> JStr("file"), "value" -> JStr("File"), "popup" -> JObject(Map("menuitem" -> JArray(List(JObject(Map("value" -> JStr("New"), "onclick" -> JStr("CreateNewDoc()"))), JObject(Map("value" -> JStr("Open"), "onclick" -> JStr("OpenDoc()"))), JObject(Map("value" -> JStr("Close"), "onclick" -> JStr("CloseDoc()"))))))))))))
  }

}
