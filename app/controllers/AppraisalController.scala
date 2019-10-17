package controllers

import java.nio.file.Paths

import authentication.AuthenticatedAction
import javax.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, AnyContent, Controller}
import models.AppraisalForm

import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits.defaultContext


class AppraisalController @Inject()(implicit val messagesApi: MessagesApi) extends Controller with I18nSupport {


  def appraisal = AuthenticatedAction { implicit request =>
    Ok(views.html.appraisal(AppraisalForm.appraisalForm))
  }

  def appraisalHandler = TODO

  def appraisalSubmit: Action[AnyContent] = Action.async { implicit request =>
    AppraisalForm.appraisalForm.bindFromRequest.fold({ formWithErrors =>
      Future(BadRequest(views.html.appraisal(formWithErrors)))
    }, { appraisalDetails =>
      AppraisalForm.addElement(appraisalDetails)
      Future {
        Redirect(routes.GalleryController.gallery())
      }
    })


  }


}
