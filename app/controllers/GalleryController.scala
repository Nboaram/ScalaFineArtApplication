package controllers

import akka.stream.Materializer
import helpers.Constants
import javax.inject.Inject
import play.api.i18n.{I18nSupport, Lang, MessagesApi}
import play.api.mvc.{Action, Controller}

class GalleryController @Inject()
(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def gallery  = Action {implicit request =>
    Ok(views.html.gallery(Constants.imagesPlaceholder.toString))
  }

  def view = Action { implicit request =>
    Ok(views.html.view())
  }

  def appraisal = Action { implicit request =>
    Ok(views.html.appraisal())
  }

}