package models

import play.api.data.Form
import helpers.Constants
import play.api.data.validation.{Constraint, Invalid, Valid, ValidationError}
import play.api.data.Forms._

case class AppraisalForm(title: String, artist: String, description: String, genre: String, artType: String, movement: String)

object AppraisalForm {
  val signUpForm: Form[AppraisalForm] = Form(
    mapping(
      Constants.appraisalTitle.toString -> nonEmptyText(minLength = 2, maxLength = 20),
      Constants.appraisalArtist.toString -> nonEmptyText(minLength = 2, maxLength = 20),
      Constants.appraisalDescription.toString -> nonEmptyText(minLength = 2, maxLength = 100),
      Constants.appraisalGenre.toString -> nonEmptyText(minLength = 3, maxLength = 20),
      Constants.appraisalArtType.toString -> nonEmptyText(minLength = 5, maxLength = 20),
      Constants.appraisalMovement.toString -> nonEmptyText(minLength = 5, maxLength = 20)
      //Constants.appraisalOriginal -> boolean)


    )(AppraisalForm.apply)(AppraisalForm.unapply)
  )
}



// file, title, artist, description, genre, art type, movement, original
// customer id from session storage,
