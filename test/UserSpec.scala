  import org.specs2.mutable._
  import play.api.test.Helpers._
  import play.api.test.{WithApplication, _}


  class UserSpec extends Specification {

    "User" should {

      "render the login page" in new WithApplication {
        val login = route(FakeRequest(GET, "/login")).get

        status(login) must equalTo(OK)
        contentType(login) must beSome.which(_ == "text/html")
      }

      "render the account page" in new WithApplication {
        val account = route(FakeRequest(GET, "/account")).get

        status(account) must equalTo(OK)
        contentType(account) must beSome.which(_ == "text/html")
      }
    }

  }