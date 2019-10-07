package controllers

import play.api.mvc.{Action, Controller}

class UserController extends Controller {

  def login = Action {
    Ok(views.html.login())
  }

  def register = Action {
    Ok(views.html.register())
  }

  def account = Action {
    Ok(views.html.account())
  }





}