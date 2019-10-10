package controllers

import authentication.AuthenticatedAction
import helpers.Constants
import javax.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

class GalleryController @Inject()(implicit val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def gallery  = Action {implicit request =>
    Ok(views.html.gallery(Constants.imagesPlaceholder.toString))
  }

  def view(image: String) = Action { implicit request =>
    Ok(views.html.view(image))
  }

  def appraisal = AuthenticatedAction { implicit request =>
    Ok(views.html.appraisal())
  }

  def appraisalHandler = TODO

}