package controllers

import helpers.Constants
import play.api.mvc._

class Application extends Controller {

  def index: Action[AnyContent] = Action {
    request =>
      request.flash.get(Constants.login.toString).map(welcomeMessage => Ok(views.html.index(welcomeMessage)))
        .getOrElse(Ok(views.html.index(Constants.indexString.toString)))
  }

  def contact = Action {
    Ok(views.html.contact())
  }

}