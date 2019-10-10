package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import akka.stream.Materializer
import email.EmailClient
import helpers.Constants
import models.{ForgotPassword, LoginDetails}
import play.api.i18n.{I18nSupport, MessagesApi}
import javax.inject.Inject
import play.api.mvc.{Action, AnyContent, Controller}

import scala.concurrent.Future

class LoginController @Inject()(implicit val messagesApi: MessagesApi, val materializer: Materializer) extends Controller
  with I18nSupport {

  def login: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok(views.html.login(LoginDetails.loginForm))
    }
  }

  def loginSubmit: Action[AnyContent] = Action.async { implicit request =>
    LoginDetails.loginForm.bindFromRequest.fold({
      _ => {
        Future(Redirect(routes.LoginController.login()).flashing(Constants.failed.toString ->
          Constants.incorrectUsername.toString
        ))
      }
    },
      {
        details =>
          Future {
            Redirect(routes.Application.index())
              .withSession(request.session + (Constants.username.toString -> details.username))
              .flashing(Constants.login.toString -> Constants.loginMessage.toString)
          }
      })
  }

  def forgotPassword: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.forgot_password(ForgotPassword.forgotPasswordForm))
  }

  def forgotPasswordHandler: Action[AnyContent] = Action { implicit request =>
    ForgotPassword.forgotPasswordForm.bindFromRequest.fold({ formHasErrors =>
      BadRequest(views.html.forgot_password(formHasErrors))
    }, { success =>
      EmailClient.sendPasswordRecoveryEmail(success.email)
      Ok(views.html.recovery_email_sent())
    })
  }

}