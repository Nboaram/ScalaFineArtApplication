package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action { request =>
    request.session.get("username").map{ user =>
      Ok(views.html.index("Your application is ready Mr." + user))
    }.getOrElse{
      Ok(views.html.index("Your application is ready."))
    }
  }
}