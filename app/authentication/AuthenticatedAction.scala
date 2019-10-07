package authentication

import controllers.routes
import models.LoginDetails
import play.api.mvc._

import scala.concurrent.Future

object AuthenticatedAction extends ActionBuilder[AuthenticatedRequest] with Controller {
  def invokeBlock[A](request: Request[A], block: AuthenticatedRequest[A] => Future[Result]): Future[Result] = {
    request.session.get("username")
      .map(LoginDetails.checkUser)
      .map(value => block(new AuthenticatedRequest(value, request)))
      .getOrElse(Future.successful(Redirect(routes.LoginController.login())))
  }
}