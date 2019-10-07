package models

import helpers.Constants
import play.api.data.Forms._
import play.api.data._

case class LoginDetails(username: String, password: String)

object LoginDetails {

  val loginForm = Form(
    mapping(
      Constants.username.toString -> nonEmptyText,
      Constants.password.toString -> nonEmptyText
    )(LoginDetails.apply)(LoginDetails.unapply)
  )

  def checkCredentials(loginDetails: LoginDetails): Boolean = {
    if (loginDetails.username == Constants.admin.toString && loginDetails.password == Constants.password.toString)
      true
    else
      false
  }

  def checkUser(loginDetails: String): String = {
    if (loginDetails == Constants.admin.toString)
      Constants.admin.toString
    else
      Constants.emptyString.toString
  }

}