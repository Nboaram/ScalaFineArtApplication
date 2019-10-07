package controllers

import play.api.mvc.{Action, Controller}

class RegisterController extends Controller {

  def register = Action {
    Ok(views.html.register())
  }

}
