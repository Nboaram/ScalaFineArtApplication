import controllers.routes
import helpers.Constants
import org.specs2.mutable._
import play.api.mvc.Result
import play.api.test.Helpers._
import play.api.test.{WithApplication, _}

import scala.concurrent.Future


class PaymentSpec extends Specification {

  "Payment" should {

    "render the checkout page" in new WithApplication {
      val checkout: Future[Result] = route(FakeRequest(GET, routes.PaymentController.checkout().path())).get
      status(checkout) must equalTo(OK)
      contentType(checkout) must beSome.which(_ == HTML)
    }
  }

}