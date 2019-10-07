package controllers.navigation

import play.api.mvc._

class Footer extends Controller {

  def footer() = Action {
    Ok(views.html.footer("Footer")(false))
  }

}
