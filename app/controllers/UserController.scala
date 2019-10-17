package controllers

import akka.stream.Materializer
import authentication.AuthenticatedAction
import helpers.Constants
import javax.inject.Inject
import models.Interests.{ArtGenre, ArtMovement, ArtType, Interests}
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.{Action, AnyContent, Controller}

import scala.concurrent.Future

class UserController @Inject()(implicit val messagesApi: MessagesApi, val materializer: Materializer) extends Controller
  with I18nSupport {

  def account: Action[AnyContent] = AuthenticatedAction { implicit request =>
    Ok(views.html.account(request.session.get(Constants.username.toString).getOrElse(Constants.emptyString.toString)))
  }

  def interests: Action[AnyContent] = AuthenticatedAction.async { implicit request =>
    val myInterests = Interests.interestsDatabase.get(request.session.get(Constants.username.toString).getOrElse(""))
    if (myInterests.isDefined) {
      Future(Ok(views.html.main("Interests")(views.html.interests(Interests.interestsForm.fill(myInterests.get)))))
    }
    else Future(Ok(views.html.main("Interests")(views.html.interests(Interests.interestsForm))))
  }


    def interestsSubmit: Action[AnyContent] = AuthenticatedAction.async {
      implicit request => {
        Interests.interestsForm.bindFromRequest.fold({
          formWithErrors => Future(BadRequest(views.html.interests(formWithErrors)))
        }, {
          interests =>
            Interests.addElement(request.session.get(Constants.username.toString).get, interests)
            Future {
              Redirect(routes.Application.index())
                .flashing(Constants.success.toString -> Constants.interestsUpdated.toString)
            }
        })
      }
    }

  }