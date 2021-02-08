package models

import helpers.Constants
import play.api.data.Form
import play.api.data.validation.{Constraint, Invalid, Valid, ValidationError}
import play.api.data.Forms._
import play.api.libs.json.{Format, Json}

import scala.collection.mutable.ArrayBuffer


case class SignUp(firstName: String, lastName: String, email: String, username: String, password: String)

object SignUp {
  val signUpForm: Form[SignUp] = Form(
    mapping(
      Constants.firstName.toString -> nonEmptyText(minLength = 2, maxLength = 20),
      Constants.lastName.toString -> nonEmptyText(minLength = 2, maxLength = 20),
      Constants.email.toString -> email,
      Constants.username.toString -> nonEmptyText(minLength = 3, maxLength = 20).verifying(usernameConstraint),
      Constants.password.toString -> nonEmptyText(minLength = 5, maxLength = 20)
    )(SignUp.apply)(SignUp.unapply)
  )
  //TODO Replace with mongoDB
  val users: ArrayBuffer[SignUp] = ArrayBuffer(
    //user: Fab
    // pw: password
    SignUp("Fabian", "Lewis", "abc@123.uk", "Fab", "$2a$10$SQxd9FSTlEdbopBcCxOZhOpmk.8E1EYQs06JfxSPXfJJE3UoNqKGe")
  )

  def addElement(signUp: SignUp): Unit = {
    SignUp.users.append(signUp)
  }

  implicit val formats: Format[SignUp] = Json.format[SignUp]

  def usernameConstraint: Constraint[String] = Constraint(Constants.signUpConstraint.toString)({ username =>
    if (users.map(details => details.username).contains(username))
      Invalid(ValidationError(Constants.signUpInvalid.toString))
    else Valid
  })

  override def toString = s"SignUp($signUpForm, $users, $formats)"
}