package email

import controllers.routes
import courier.{Envelope, Mailer, Text}
import helpers.Constants
import javax.inject.Singleton
import javax.mail.internet.InternetAddress

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}


object EmailClient {
  def createEmailAddress(emailAddress: String): InternetAddress = InternetAddress.parse(emailAddress).head
  val hostEmail: String = sys.env(Constants.environmentEmailAddress.toString)
  val mailer: Mailer = Mailer(Constants.emailUrl.toString, Constants.emailPort.toString.toInt)
    .auth(true)
    .as(hostEmail, sys.env(Constants.environmentEmailPassword.toString))
    .startTls(true)()
  def sendPasswordRecoveryEmail(userEmailAddress: String, passwordResetId: String): Unit = {
    val resetLink = routes.LoginController.resetPassword(passwordResetId).path()
    sendEmail(userEmailAddress, s"Copy this link into your address bar to reset your password: $resetLink")
  }


  def sendEmail(userEmailAddress: String, message: String): Unit = {
    val envelope = Envelope
      .from(createEmailAddress(hostEmail))
      .to(createEmailAddress(userEmailAddress))
      .subject(Constants.passwordRecoveryTitle.toString)
      .content(Text(message))
    mailer(envelope).onComplete{
      case Success(_) => ()
      case Failure(exception) => println("Something went wrong...")
        println(exception.getMessage)
    }
  }
}
