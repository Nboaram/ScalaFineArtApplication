package models

import helpers.Constants
import play.api.data._
import play.api.data.Forms._
import scala.collection.mutable.ArrayBuffer

case class SignUp(firstName: String, lastName: String,email:String, username: String, password: String)

object SignUp {
  val signUpForm: Form[SignUp] = Form(
    mapping(
      Constants.firstName.toString -> nonEmptyText(minLength = 2,maxLength = 20),
      Constants.lastName.toString -> nonEmptyText(minLength = 2,maxLength = 20),
      Constants.email.toString -> email,
      Constants.username.toString -> nonEmptyText(minLength = 2,maxLength = 20),
      Constants.password.toString -> nonEmptyText(minLength = 2,maxLength = 20)
    )(SignUp.apply)(SignUp.unapply).verifying(Constants.signUpInvalid.toString, signUp => isValidUsername(signUp))
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

  def isValidUsername(signUp: SignUp): Boolean = {
    signUps.count(details => details.username.equals(signUp.username)) != 1
  }

  private def lengthIsGreaterThanNCharacters(s: String, n: Int): Boolean = {
    if (s.length > n) true else false
  }

  private def lengthIsLessThanNCharacters(s: String, n: Int): Boolean = {
    if (s.length < n) true else false
  }
}