package controllers

import play.api.mvc.{Action, Controller}

class GalleryController extends Controller {

  def gallery  = Action {
    val images = "Placeholder to get images from DB"
    Ok(views.html.gallery(images))
  }

  def view = Action {
    Ok(views.html.view())
  }

  def appraisal = Action {
    Ok(views.html.appraisal())
  }

}