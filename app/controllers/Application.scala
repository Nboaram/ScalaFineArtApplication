package controllers

import helpers.Constants
import javax.inject.Inject
import play.api.i18n.{I18nSupport, Langs, MessagesApi}
import play.api._
import play.api.mvc._
import services.MongoServices
import akka.stream.Materializer

class Application @Inject()(implicit val messagesApi: MessagesApi, langs: Langs) extends Controller
  with I18nSupport {

  def index: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.index(Constants.qaArt.toString))
  }

  def contact: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.contact())
  }

  def termsOfUse: Action[AnyContent]  = Action { implicit request =>
    Ok(views.html.termsOfUse())
  }
}