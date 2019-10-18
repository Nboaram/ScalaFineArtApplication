package controllers

import java.nio.file.Paths

import helpers.Constants
import javax.inject.Inject
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

class FileUploadController @Inject()(implicit val messagesApi: MessagesApi) extends Controller with I18nSupport {



  def uploadFile = Action(parse.multipartFormData) { implicit request =>
    request.body.file(Constants.fileUpload.toString).map { file =>
      file.ref.moveTo(Paths.get(Constants.pathToTempStorage +file.filename).toFile, replace = true)
      Ok("Upload successful")
    }.getOrElse {
      Redirect(routes.AppraisalController.appraisal()).flashing(
        "error" -> "File not found")
    }
  }

}
