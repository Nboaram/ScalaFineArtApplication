package controllers

import scala.concurrent.ExecutionContext.Implicits.global
import akka.stream.Materializer
import email.EmailClient
import helpers.Constants
import models.{ForgotPassword, LoginDetails, ResetPassword}
import play.api.i18n.{I18nSupport, MessagesApi}
import javax.inject.Inject
import play.api.mvc.{Action, AnyContent, Controller}
import scala.concurrent.duration._

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
      try {
        // TODO: search the users for someone with a matching email address. If found, update their mongodb record with a unique id assigned to 'resetId'. Then send this to the user in an email.
        EmailClient.sendPasswordRecoveryEmail(success.email, System.currentTimeMillis().toString)
        Ok(views.html.recovery_email_sent())
      } catch {
        case e: Throwable => BadRequest(views.html.forgot_password(ForgotPassword.forgotPasswordForm, seriousErrorOccured = true))
      }

    })
  }

  def resetPassword(id: String): Action[AnyContent] = Action { implicit request =>
    // TODO: Search the users for someone with a matching 'resetId' field. If not found, show 404.
    val placeholderPasswordResetId = Constants.placeholderPasswordResetId.toString
    if(id.equals(placeholderPasswordResetId)) {
      Ok(views.html.reset_password(id, ResetPassword.resetPasswordForm))
    } else {
      NotFound
    }
  }

  def resetPasswordHandler(id: String): Action[AnyContent] = Action { implicit request =>
    ResetPassword.resetPasswordForm.bindFromRequest.fold({ formHasErrors =>
      BadRequest(views.html.reset_password(id, formHasErrors))
    }, { success =>
      // TODO: Find the user with a matching 'resetId' and change their password to the new one. Send a confirmation email.
      Ok(views.html.password_successfully_reset())
    })
  }

}