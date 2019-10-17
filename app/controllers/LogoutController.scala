package controllers

import akka.stream.Materializer
import helpers.Constants
import javax.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, AnyContent, Controller}
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

class LogoutController @Inject()(implicit val messagesApi: MessagesApi, val materializer: Materializer) extends Controller
  with I18nSupport {

  def logout: Action[AnyContent] = Action.async { implicit request =>
    Future{
      Redirect(routes.Application.index()).withNewSession
        .flashing(Constants.success.toString -> Constants.logoutMessage.toString)
    }
  }

}