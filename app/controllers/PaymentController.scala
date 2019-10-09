package controllers

import javax.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

class PaymentController @Inject()
(val messagesApi: MessagesApi) extends Controller with I18nSupport  {

  def checkout = Action { implicit request =>
    Ok(views.html.checkout())
  }


}