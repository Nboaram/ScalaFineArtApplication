package models

import play.api.data.Form
import helpers.Constants
import play.api.data.Forms._

import scala.collection.mutable.ArrayBuffer

case class AppraisalForm(title: String, artist: String, description: String, genre: String, artType: String, movement: String, original: Boolean = false)

object AppraisalForm {
  val appraisalForm: Form[AppraisalForm] = Form(
    mapping(
      Constants.appraisalTitle.toString -> nonEmptyText(minLength = 2, maxLength = 20),
      Constants.appraisalArtist.toString -> nonEmptyText(minLength = 2, maxLength = 20),
      Constants.appraisalDescription.toString -> nonEmptyText(minLength = 2, maxLength = 100),
      Constants.appraisalGenre.toString -> nonEmptyText(minLength = 2, maxLength = 20),
      Constants.appraisalArtType.toString -> nonEmptyText(minLength = 2, maxLength = 20),
      Constants.appraisalMovement.toString -> nonEmptyText(minLength = 2, maxLength = 20),
      Constants.appraisalOriginal.toString -> boolean

    )(AppraisalForm.apply)(AppraisalForm.unapply)
  )

  //TODO Replace with mongoDB
  val art: ArrayBuffer[AppraisalForm] = ArrayBuffer(
    AppraisalForm(
      "test",
      "Test Artist",
      "This is a test description",
      "Test Genre",
      "Test Art Type",
      "Test Movement",
      true
    )
  )

  def addElement(appraisalForm: AppraisalForm): Unit = {
    AppraisalForm.art.append(appraisalForm)
  }
}

case class UploadForm(filename: String)

object UploadForm {
  val uploadForm = Form(
    mapping(
      "filename" -> text
    )(UploadForm.apply)(UploadForm.unapply)
  )
}


// file, title, artist, description, genre, art type, movement, original
// customer id from session storage,
