package controllers

import akka.stream.Materializer
import helpers.Constants
import javax.inject.Inject
import play.api.i18n.{I18nSupport, Lang, Langs, Messages, MessagesApi}
import play.api.i18n.{I18nSupport, Lang, Langs, Messages, MessagesApi}
import play.api.mvc._
import services.MongoServices


class Application @Inject()
(val messagesApi: MessagesApi, val materializer: Materializer, val mongoServices: MongoServices, langs: Langs) extends Controller
  with I18nSupport {

  def index: Action[AnyContent] = Action { implicit request =>
    request.flash.get(Constants.login.toString).map(welcomeMessage => Ok(views.html.index(welcomeMessage)))
      .getOrElse(Ok(views.html.index(Constants.indexString.toString)))
  }

  def contact = Action {
    Ok(views.html.contact())
  }
}