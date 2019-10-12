  import controllers.routes
  import helpers.Constants
  import org.specs2.mutable._
  import play.api.mvc.Result
  import play.api.test.Helpers._
  import play.api.test.{WithApplication, _}

  import scala.concurrent.Future


  class UserSpec extends Specification {

    "User" should {

      "render the login page" in new WithApplication {
        val login = route(FakeRequest(GET, routes.LoginController.login().path)).get

        status(login) must equalTo(OK)
        contentType(login) must beSome.which(_ == HTML)
      }

      "render the account page" in new WithApplication {
        val account = route(FakeRequest(GET, routes.UserController.account().path()).withSession("username" -> "user")).get  //TODO make this a better test

        status(account) must equalTo(OK)
        contentType(account) must beSome.which(_ == HTML)
      }

      "render the password reset page" in new WithApplication() {
        val forgotPassword: Future[Result] = route(app, FakeRequest(GET, routes.LoginController.forgotPassword().path)).get

        status(forgotPassword) must equalTo(OK)
        contentType(forgotPassword) must beSome.which(_ == HTML)
      }
    }

  }