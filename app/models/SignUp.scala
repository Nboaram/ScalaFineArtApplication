package models

import helpers.Constants
import play.api.data.Form
import play.api.data.validation.{Constraint, Invalid, Valid, ValidationError}
import play.api.data.Forms._
import scala.collection.mutable.ArrayBuffer


case class SignUp(firstName: String, lastName: String,email:String, username: String, password: String)

object SignUp {
  val signUpForm: Form[SignUp] = Form(
    mapping(
      Constants.firstName.toString -> nonEmptyText(minLength = 2,maxLength = 20),
      Constants.lastName.toString -> nonEmptyText(minLength = 2,maxLength = 20),
      Constants.email.toString -> email,
      Constants.username.toString -> nonEmptyText(minLength = 3, maxLength = 20).verifying(usernameConstraint),
      Constants.password.toString -> nonEmptyText(minLength = 5,maxLength = 20)
    )(SignUp.apply)(SignUp.unapply)
  )
  //TODO Replace with mongoDB
  val signUps: ArrayBuffer[SignUp] = ArrayBuffer(
    SignUp("Fabian", "Lewis","abc@123.uk",  "Fab", "password"),
    SignUp("Rameez", "J","abcd@123.uk", "Rico", "password"),
    SignUp("Steven", "B","abcde@123.uk", "Steve", "password")
  )

  def addElement(signUp: SignUp): Unit = {
    SignUp.signUps.append(signUp)
  }

  def usernameConstraint: Constraint[String] = Constraint(Constants.signUpInvalid.toString)({ username =>
    if (signUps.map(details => details.username).contains(username))
      Invalid(ValidationError(Constants.signUpInvalid.toString))
    else Valid
  })
}