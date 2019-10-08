package controllers

import akka.stream.Materializer
import authentication.AuthenticatedAction
import helpers.Constants
import models.LoginDetails
import play.api.i18n.{I18nSupport, MessagesApi}
import javax.inject.Inject
import play.api.mvc.{Action, AnyContent, Controller}
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

class UserController @Inject()
(val messagesApi: MessagesApi, val materializer: Materializer) extends Controller
  with I18nSupport {

  def register: Action[AnyContent] = Action {
    Ok(views.html.register())
  }

  def account: Action[AnyContent] = AuthenticatedAction { request =>
    Ok(s"Hello ${request.session.get("username").getOrElse("")}")
  }

}