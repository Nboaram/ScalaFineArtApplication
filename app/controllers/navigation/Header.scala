package controllers.navigation

import play.api.mvc._

class Header extends Controller{

  def header() = Action {
    Ok(views.html.header("Header")(false))
  }

}
