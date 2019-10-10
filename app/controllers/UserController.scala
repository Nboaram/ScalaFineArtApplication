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

  def interests: Action[AnyContent] = AuthenticatedAction {implicit request =>
    Ok(views.html.main("Interests")(views.html.interests()))
  }

  def interests2: Action[AnyContent] = AuthenticatedAction.async {implicit request =>
    val filledInterests = Interests(ArtType.values.map(value=>value.toString).toList,
      ArtGenre.values.map(value=>value.toString).toList, ArtMovement.values.map(value=>value.toString).toList)
    println(filledInterests.toString)
    println(Interests.interestsForm)
    println(Interests.interestsForm.fill(filledInterests))
    Future {
      Ok(views.html.main("Interests")(views.html.interests2(Interests.interestsForm.fill(filledInterests))))
    }
  }

  def interestsSubmit: Action[AnyContent] = AuthenticatedAction {implicit request =>{
    println(request.body)
    Ok(views.html.main("Your Interests")(views.html.interestsSubmit()))}
  }

  def artTypesSubmit: Action[AnyContent] = AuthenticatedAction {implicit request =>
    Ok("hi")
  }

  def artGenresSubmit: Action[AnyContent] = AuthenticatedAction {implicit request =>
    Ok("hi")
  }

  def artMovementsSubmit: Action[AnyContent] = AuthenticatedAction {implicit request =>
    Ok("hi")
  }

}