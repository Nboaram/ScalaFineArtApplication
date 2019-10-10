  import controllers.routes
  import org.specs2.mutable._
  import play.api.mvc.Result
  import play.api.test.Helpers._
  import play.api.test.{WithApplication, _}

  import scala.concurrent.Future


  class UserSpec extends Specification {

    "User" should {

      "render the login page" in new WithApplication {
        val login: Future[Result] = route(FakeRequest(GET, routes.LoginController.login().path())).get

        status(login) must equalTo(OK)
        contentType(login) must beSome.which(_ == HTML)
      }

      "be redirected if not logged in" in new WithApplication {
        val account: Future[Result] = route(FakeRequest(GET, routes.UserController.account().path())).get

        status(account) must equalTo(SEE_OTHER)
        contentType(account) must beNone
      }
    }

  }