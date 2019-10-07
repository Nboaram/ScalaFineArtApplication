package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import akka.stream.Materializer
import helpers.Constants
import models.{LoginDetails, SignUp}
import play.api.i18n.{I18nSupport, MessagesApi}
import javax.inject.Inject
import play.api.mvc.{Action, AnyContent, Controller}

import scala.concurrent.Future

class LoginController @Inject()
(val messagesApi: MessagesApi, val materializer: Materializer) extends Controller
  with I18nSupport {

  def login: Action[AnyContent] = Action.async { implicit request =>
    Future{
      Ok(views.html.login(LoginDetails.loginForm))
    }
  }

  def loginSubmit: Action[AnyContent] = Action.async { implicit request =>
    var loginDetails = LoginDetails(Constants.emptyString.toString, Constants.emptyString.toString)
    LoginDetails.loginForm.bindFromRequest.fold({
      formWithErrors =>
      BadRequest(views.html.login(formWithErrors))
    },
      {
        details =>
      println(details.username + " " + details.password)
      loginDetails = details
    })

    {
      if (SignUp.validUser(loginDetails)) {
        println("Valid user")
      Future{Redirect(routes.Application.index())
          .withSession(request.session + (Constants.username.toString -> loginDetails.username))
          .flashing(Constants.login.toString -> Constants.loginMessage.toString)}
      } else {
        println("Invalid user")
        Future{Redirect(routes.LoginController.login())}
      }
    }
  }

}