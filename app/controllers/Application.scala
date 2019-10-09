package controllers

import helpers.Constants
<
import javax.inject.Inject
import play.api.i18n.{I18nSupport, Langs, MessagesApi}
import play.api._
import play.api.mvc._



class Application @Inject()
(val messagesApi: MessagesApi, val materializer: Materializer, val mongoServices: MongoServices, langs: Langs) extends Controller
  with I18nSupport {

  def index: Action[AnyContent] = Action { request =>
    request.session.get(Constants.username.toString).map{ user =>
      Ok(views.html.index(Constants.indexString.toString + Constants.space.toString + user))
    }.getOrElse{
      Ok(views.html.index(Constants.indexString.toString))
    }
  }

  def contact = Action {
    Ok(views.html.contact())
  }
}