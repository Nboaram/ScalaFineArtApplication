package controllers

import akka.stream.Materializer
import helpers.Constants
import javax.inject.Inject
import models.SignUp
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, AnyContent, Controller}
import helpers.JsonFormats._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import scala.concurrent.Future
class SignUpController @Inject()(val messagesApi: MessagesApi, val materializer: Materializer) extends Controller with I18nSupport {

  def signUp: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok(views.html.signUp(SignUp.signUpForm))
    }
  }

  def signUpSubmit: Action[AnyContent] = Action.async { implicit request =>
    SignUp.signUpForm.bindFromRequest.fold({ formWithErrors =>
      Future(BadRequest(views.html.signUp(formWithErrors)))
    }, { signUpDetails =>
      SignUp.addElement(signUpDetails)
      Future {
        Redirect(routes.Application.index())
          .withSession(Constants.username.toString -> signUpDetails.username)
          .flashing(Constants.login.toString -> Constants.signUpMessage.toString)
      }
    })


  }
}
