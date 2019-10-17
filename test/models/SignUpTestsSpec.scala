package models

import scala.resources.BaseTestingClass
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

class SignUpTestsSpec extends WordSpec with Matchers {
  "Parsing valid JSON to a SignUP model" should {
    "result in a valid model" in {
      val json = Json.obj(
        "firstName" -> "a first name",
        "lastName" -> "a second name",
        "email" -> "an email",
        "userName" -> "a username",
        "password" -> "the password"
      )

      val model = SignUp(
        "a first name",
        "a second name",
        "an email",
        "a username",
        "the password"
      )

      json.as[SignUp] shouldBe model
    }
  }
}
