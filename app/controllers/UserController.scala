package controllers

import akka.stream.Materializer
import authentication.AuthenticatedAction
import helpers.Constants
import javax.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, AnyContent, Controller}

class UserController @Inject()
(val messagesApi: MessagesApi, val materializer: Materializer) extends Controller
  with I18nSupport {

  def account: Action[AnyContent] = AuthenticatedAction { request =>
    Ok(s"Hello ${request.session.get("username").getOrElse(Constants.emptyString.toString)}")
  }

}