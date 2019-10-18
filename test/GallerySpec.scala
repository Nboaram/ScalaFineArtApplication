import controllers.routes
import helpers.Constants
import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test.{WithApplication, _}


class GallerySpec extends Specification {

  "Gallery" should {

    "render the gallery page" in new WithApplication {
      val gallery = route(FakeRequest(GET, routes.GalleryController.gallery().path())).get

      status(gallery) must equalTo(OK)
      contentType(gallery) must beSome.which(_ == HTML)
    }

    "render the view page" in new WithApplication {
      val view = route(FakeRequest(GET, routes.GalleryController.view().path())).get

      status(view) must equalTo(OK)
      contentType(view) must beSome.which(_ == HTML)
    }

    "render the appraisal page" in new WithApplication {
      val appraisal = route(FakeRequest(GET, routes.AppraisalController.appraisal().path()).withSession("username" -> "user")).get //TODO make this a better test

      status(appraisal) must equalTo(OK)
      contentType(appraisal) must beSome.which(_ == HTML)
    }
  }

}
