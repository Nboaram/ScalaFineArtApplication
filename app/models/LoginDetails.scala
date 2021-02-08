package models

import helpers.Constants
import models.SignUp.users
import org.mindrot.jbcrypt.BCrypt
import play.api.data.Forms._
import play.api.data._
import play.api.data.validation.{Constraint, Invalid, Valid, ValidationError}
import play.api.libs.json.{Format, Json}

case class LoginDetails(username: String, password: String)

object LoginDetails {

  val loginForm = Form(
    mapping(
      Constants.username.toString -> nonEmptyText,
      Constants.password.toString -> nonEmptyText
    )(LoginDetails.apply)(LoginDetails.unapply).verifying(userConstraint)
  )
  def userConstraint: Constraint[LoginDetails] = Constraint(Constants.emptyString.toString)({ loginDetails =>
    if (validUser(loginDetails)) {
      Valid
    }
    else {
      Invalid(ValidationError(Constants.emptyString.toString))
    }
  })

  implicit val formats: Format[LoginDetails] = Json.format[LoginDetails]

  def validUser(loginDetails: LoginDetails): Boolean = {
    println(SignUp.users)
    users.exists(user => user.username.equals(loginDetails.username) && BCrypt.checkpw(loginDetails.password, user.password))
  }

}