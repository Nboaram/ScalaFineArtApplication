import helpers.Constants
import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test.{WithApplication, _}


class RegisterSpec extends Specification {

  "Register" should {

    "render the register page" in new WithApplication {
      val Register = route(FakeRequest(GET, Constants.registerUrl.toString)).get

      status(Register) must equalTo(OK)
      contentType(Register) must beSome.which(_ == Constants.text_html.toString)
    }
  }

}