package models

import helpers.Constants
import play.api.data.Form
import play.api.data.Forms._

case class ForgotPassword(email: String)

object ForgotPassword {
  val forgotPasswordForm =
    Form(mapping(Constants.email.toString -> nonEmptyText)(ForgotPassword.apply)(ForgotPassword.unapply)
  )
}
