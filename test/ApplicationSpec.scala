import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.test.{WithApplication, _}
import play.api.test.Helpers._
import helpers.Constants

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication {
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "render the index page" in new WithApplication {
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == Constants.text_html.toString)
      contentAsString(home) must contain("Your new application is ready")
    }

    "render the contact page" in new WithApplication {
      val contact = route(FakeRequest(GET, Constants.contactUrl.toString)).get

      status(contact) must equalTo(OK)
      contentType(contact) must beSome.which(_ == Constants.text_html.toString)
    }
  }

}
