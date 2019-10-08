package models

import helpers.Constants
import models.SignUp.signUps
import play.api.data.Forms._
import play.api.data._
import play.api.data.validation.{Constraint, Invalid, Valid, ValidationError}

case class LoginDetails(username: String, password: String)

object LoginDetails {

  val loginForm = Form(
    mapping(
      Constants.username.toString -> nonEmptyText,
      Constants.password.toString -> nonEmptyText
    )(LoginDetails.apply)(LoginDetails.unapply).verifying(userConstraint)
  )
  def userConstraint: Constraint[LoginDetails] = Constraint("")({ loginDetails =>
    if (validUser(loginDetails)) {
      Valid
    }
    else {
      Invalid(ValidationError(""))
    }
  })

  def validUser(loginDetails: LoginDetails): Boolean = {
    signUps.count(result =>
      if (result.username.equals(loginDetails.username) && result.password.equals(loginDetails.password)) {
        true
      }
      else {
        false
      }
    )==1
  }

}