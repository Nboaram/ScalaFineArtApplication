package controllers

import helpers.Constants
import play.api.mvc.{Action, Controller}

class GalleryController extends Controller {

  def gallery  = Action {
    Ok(views.html.gallery(Constants.imagesPlaceholder.toString))
  }

  def view = Action {
    Ok(views.html.view())
  }

  def appraisal = Action {
    Ok(views.html.appraisal())
  }

}