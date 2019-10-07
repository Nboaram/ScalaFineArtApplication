import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test.{WithApplication, _}


class GallerySpec extends Specification {

  "Gallery" should {

    "render the gallery page" in new WithApplication {
      val gallery = route(FakeRequest(GET, "/gallery")).get

      status(gallery) must equalTo(OK)
      contentType(gallery) must beSome.which(_ == "text/html")
    }

    "render the view page" in new WithApplication {
      val view = route(FakeRequest(GET, "/view")).get

      status(view) must equalTo(OK)
      contentType(view) must beSome.which(_ == "text/html")
    }

    "render the appraisal page" in new WithApplication {
      val appraisal = route(FakeRequest(GET, "/appraisal")).get

      status(appraisal) must equalTo(OK)
      contentType(appraisal) must beSome.which(_ == "text/html")
    }
  }

}
