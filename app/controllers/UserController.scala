package controllers

import akka.stream.Materializer
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

  def login: Action[AnyContent] = Action.async { implicit request =>
    Future{
      Ok(views.html.login(LoginDetails.loginForm))
    }
  }

  def register = Action {
    Ok(views.html.register())
  }

  def account = Action {
    Ok(views.html.account())
  }





}