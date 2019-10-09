package controllers

import helpers.Constants
import play.api.mvc.{Action, Controller}

class GalleryController extends Controller {

  def gallery  = Action {implicit request =>
    Ok(views.html.gallery(Constants.imagesPlaceholder.toString))
  }

  def view = Action { implicit request =>
    Ok(views.html.view())
  }

  def appraisal = Action {implicit request =>
    Ok(views.html.appraisal())
  }

}