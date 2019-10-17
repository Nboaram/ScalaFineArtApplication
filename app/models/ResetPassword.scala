package models

import helpers.Constants
import play.api.data.{Form, Mapping}
import play.api.data.Forms._
import play.api.data.validation.{Constraint, Invalid, Valid, ValidationError}

case class ResetPassword(newPassword: String, confirmPassword: String)

object ResetPassword {
  val passwordText: Mapping[String] = nonEmptyText(minLength = 5, maxLength = 20)
  val resetPasswordForm = Form(
    mapping("newPassword" -> passwordText, "confirmPassword" -> passwordText
    )(ResetPassword.apply)(ResetPassword.unapply).verifying(passwordsMatch)
  )

  def passwordsMatch: Constraint[ResetPassword] =
    Constraint(Constants.confirmPasswordsMatchName.toString)(resetPassword =>
      if(resetPassword.newPassword.equals(resetPassword.confirmPassword)) Valid
      else Invalid(ValidationError(Constants.confirmPasswordMismatchDescription.toString))
    )

}
