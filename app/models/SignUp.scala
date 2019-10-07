package models

import helpers.Constants
import play.api.data._
import play.api.data.Forms._
import scala.collection.mutable.ArrayBuffer

case class SignUp(firstName:String, lastName:String, username: String, password: String)

object SignUp {
  val signUpForm: Form[SignUp] = Form (
    mapping(
      Constants.firstName.toString -> nonEmptyText
        .verifying("too few chars",  s => lengthIsGreaterThanNCharacters(s, 2))
        .verifying("too many chars", s => lengthIsLessThanNCharacters(s, 20)),
      Constants.lastName.toString -> nonEmptyText
        .verifying("too few chars",  s => lengthIsGreaterThanNCharacters(s, 2))
        .verifying("too many chars", s => lengthIsLessThanNCharacters(s, 20)),
      Constants.username.toString -> nonEmptyText
        .verifying("too few chars",  s => lengthIsGreaterThanNCharacters(s, 2))
        .verifying("too many chars", s => lengthIsLessThanNCharacters(s, 20)),
      Constants.password.toString -> nonEmptyText
        .verifying("too few chars",  s => lengthIsGreaterThanNCharacters(s, 2))
        .verifying("too many chars", s => lengthIsLessThanNCharacters(s, 30))
    )(SignUp.apply)(SignUp.unapply)
  )
  //TODO Replace with mongoDB
  val signUps: ArrayBuffer[SignUp] = ArrayBuffer(
    SignUp("Fabian", "Lewis", "Fab", "password"),
    SignUp("Rameez", "J", "Rico", "password"),
    SignUp("Steven", "B", "Steve", "password")
  )
  def addElement(signUp: SignUp):Unit={
    SignUp.signUps.append(signUp)
  }
  def validUsername(signUp: SignUp):Boolean={
    signUps.count(details => details.username.equals(signUp.username))==1
  }

  private def lengthIsGreaterThanNCharacters(s: String, n: Int): Boolean = {
    if (s.length > n) true else false
  }
  private def lengthIsLessThanNCharacters(s: String, n: Int): Boolean = {
    if (s.length < n) true else false
  }
}