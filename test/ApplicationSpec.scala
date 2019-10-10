import controllers.routes
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.test.{WithApplication, _}
import play.api.test.Helpers._
import helpers.Constants
import play.api.mvc

import scala.concurrent.Future

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication {
      val badRequest: Future[mvc.Result] = route(FakeRequest(GET, Constants.badUrl.toString)).get
      status(badRequest) must equalTo(NOT_FOUND)
    }

    "render the index page" in new WithApplication {
      val home: Future[mvc.Result] = route(FakeRequest(GET, routes.Application.index().path())).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == HTML)
      contentAsString(home) must contain(Constants.indexString.toString)
    }

    "render the contact page" in new WithApplication {
      val contact: Future[mvc.Result] = route(FakeRequest(GET, routes.Application.contact().path())).get

      status(contact) must equalTo(OK)
      contentType(contact) must beSome.which(_ == HTML)
    }
  }

}
