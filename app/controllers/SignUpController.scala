package controllers

import akka.stream.Materializer
import helpers.Constants
import javax.inject.Inject
import models.SignUp
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.{Action, AnyContent, Controller}
import utils.encryption.Encryption

import scala.concurrent.Future
class SignUpController @Inject()(implicit val messagesApi: MessagesApi, val materializer: Materializer) extends Controller with I18nSupport {

  def signUp: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok(views.html.signUp(SignUp.signUpForm))
    }
  }

  def signUpSubmit: Action[AnyContent] = Action.async { implicit request =>
    SignUp.signUpForm.bindFromRequest.fold({ formWithErrors =>
      Future(BadRequest(views.html.signUp(formWithErrors)))
    }, { signUpDetails =>
      println(SignUp.users)
      SignUp.addElement(signUpDetails.copy(password = Encryption.hashPassword(signUpDetails.password)))
      println(SignUp.users)
      Future {
        Redirect(routes.Application.index())
          .withSession(Constants.username.toString -> signUpDetails.username)
          .flashing(Constants.success.toString -> Constants.signUpMessage.toString)
      }
    })


  }
}
