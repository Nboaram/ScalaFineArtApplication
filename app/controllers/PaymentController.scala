package controllers

import play.api.mvc.{Action, Controller}

class PaymentController extends Controller {

  def checkout = Action { implicit request =>
    Ok(views.html.checkout())
  }


}