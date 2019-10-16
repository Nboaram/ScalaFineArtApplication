package controllers

import authentication.AuthenticatedAction
import javax.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.Controller

class AppraisalController @Inject()(implicit val messagesApi: MessagesApi) extends Controller with I18nSupport {


  def appraisal = AuthenticatedAction { implicit request =>
    Ok(views.html.appraisal())
  }

  def appraisalHandler = TODO

}
