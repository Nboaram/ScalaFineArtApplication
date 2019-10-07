package helpers

import models.SignUp
import play.api.libs.json._

object JsonFormats {

  implicit val feedFormat = Json.format[SignUp]

}