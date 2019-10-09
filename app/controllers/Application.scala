package controllers

import helpers.Constants
import play.api.mvc._

class Application extends Controller {

  def index: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.index(Constants.qaArt.toString))
  }

  def contact: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.contact())
  }

}