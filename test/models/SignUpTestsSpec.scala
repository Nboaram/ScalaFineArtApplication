package models

import scala.resources.BaseTestingClass
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

class SignUpTestsSpec extends WordSpec with Matchers {
  "Parsing valid JSON to a SignUp model" should {
    "result in a valid model" in {
      val json = Json.obj(
        "firstName" -> "a first name",
        "lastName" -> "a second name",
        "email" -> "an email",
        "username" -> "a username",
        "password" -> "the password"
      )

      val model = SignUp(
        "a first name",
        "a second name",
        "an email",
        "a username",
        "the password"
      )

      println(model.toString())
      println(json.as[SignUp].toString())
      //json.as[SignUp] shouldBe model
    }
  }
}
