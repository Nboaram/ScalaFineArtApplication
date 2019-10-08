package models

import helpers.Constants
import models.SignUp.signUps
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
  
  def validUser(loginDetails: LoginDetails): Boolean = {
    signUps.count(result =>
      if (result.username.equals(loginDetails.username) && result.password.equals(loginDetails.password)) {
        println("USERNAME: " + result.username + " " + loginDetails.username)
        println("PASSWORD: " + result.password + " " + loginDetails.password)
        true
      }
      else {
        false
      }
    )==1
  }

}