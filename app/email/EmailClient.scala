package email

import courier.{Envelope, Mailer, Text}
import helpers.Constants
import javax.inject.Singleton
import javax.mail.internet.InternetAddress
import scala.concurrent.ExecutionContext.Implicits.global

import scala.util.{Failure, Success}



@Singleton
object EmailClient {
  def createEmailAddress(emailAddress: String): InternetAddress = InternetAddress.parse(emailAddress).head
  val hostEmail: String = sys.env(Constants.environmentEmailAddress.toString)
  val mailer: Mailer = Mailer(Constants.emailUrl.toString, Constants.emailPort.toString.toInt)
    .auth(true)
    .as(hostEmail, sys.env(Constants.environmentEmailPassword.toString))
    .startTls(true)()
  def sendPasswordRecoveryEmail(userEmailAddress: String): Unit = {
    val envelope = Envelope
      .from(createEmailAddress(hostEmail))
      .to(createEmailAddress(userEmailAddress))
      .subject(Constants.passwordRecoveryTitle.toString)
      .content(Text("Copy this link to reset your password: <reset link>"))
    mailer(envelope).onComplete{
      case Success(value) => println("Email was sent!!!")
      case Failure(exception) => println("Something went wrong...")
        println(exception.getMessage)
    }
  }
}
