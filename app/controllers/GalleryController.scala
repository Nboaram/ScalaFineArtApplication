package controllers

import play.api.mvc.{Action, Controller}

class GalleryController extends Controller {

  def gallery = Action {
    Ok(views.html.gallery())
  }

  def view = Action {
    Ok(views.html.view())
  }

  def appraisal = Action {
    Ok(views.html.appraisal())
  }

  def appraisalHandler = TODO

}