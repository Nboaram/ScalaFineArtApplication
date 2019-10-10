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
    Ok(views.html.account(request.session.get(Constants.username.toString).getOrElse(Constants.emptyString.toString)))
  }

  def interests: Action[AnyContent] = AuthenticatedAction {implicit request =>
    Ok(views.html.main("Interests")(views.html.interests()))
  }

  def artTypesSubmit: Action[AnyContent] = AuthenticatedAction {implicit request =>
    Ok("hi")
  }

  def artGenresSubmit: Action[AnyContent] = AuthenticatedAction {implicit request =>
    Ok("hi")
  }

  def artMovementsSubmit: Action[AnyContent] = AuthenticatedAction {implicit request =>
    Ok("hi")
  }

}