package controllers

import play.api.mvc.{Action, Controller}

class PaymentController extends Controller {

  def checkout = Action {
    Ok(views.html.checkout())
  }


}