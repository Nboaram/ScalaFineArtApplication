package controllers

import helpers.Constants
import play.api._
import play.api.mvc._

class Application extends Controller {

  def index: Action[AnyContent] = Action { request =>
    request.session.get(Constants.username.toString).map{ user =>
      Ok(views.html.index(Constants.indexString.toString + Constants.emptyString.toString + user))
    }.getOrElse{
      Ok(views.html.index(Constants.indexString.toString))
    }
  }

  def contact: Action[AnyContent] = Action {
    Ok(views.html.contact())
  }

}