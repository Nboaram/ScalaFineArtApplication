import helpers.Constants
import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test.{WithApplication, _}


class GallerySpec extends Specification {

  "Gallery" should {

    "render the gallery page" in new WithApplication {
      val gallery = route(FakeRequest(GET, Constants.galleryUrl.toString)).get

      status(gallery) must equalTo(OK)
      contentType(gallery) must beSome.which(_ == Constants.text_html.toString)
    }

    "render the view page" in new WithApplication {
      val view = route(FakeRequest(GET, Constants.viewUrl.toString)).get

      status(view) must equalTo(OK)
      contentType(view) must beSome.which(_ == Constants.text_html.toString)
    }

    "render the appraisal page" in new WithApplication {
      val appraisal = route(FakeRequest(GET, Constants.appraisalUrl.toString)).get

      status(appraisal) must equalTo(OK)
      contentType(appraisal) must beSome.which(_ == Constants.text_html.toString)
    }
  }

}
