import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test.{WithApplication, _}


class PaymentSpec extends Specification {

  "Payment" should {

    "render the checkout page" in new WithApplication {
      val checkout = route(FakeRequest(GET, "/checkout")).get

      status(checkout) must equalTo(OK)
      contentType(checkout) must beSome.which(_ == "text/html")
    }
  }

}