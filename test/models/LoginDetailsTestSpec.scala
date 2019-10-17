package models

import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

class LoginDetailsTestSpec extends WordSpec with Matchers {
  "Parsing valid JSON to a LoginDetails model" should {
    "result in a valid model" in {
      val json = Json.obj(
        "username" -> "a username",
        "password" -> "the password"
      )

      val model = LoginDetails(
        "a username",
        "the password"
      )

      json.as[LoginDetails] shouldBe model
    }
  }
}
