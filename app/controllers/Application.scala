package controllers

import implementation.MongoServicesImpl
import javax.inject.Inject
import play.api._
import play.api.mvc._


class Application @Inject() (val mongoServicesImpl: MongoServicesImpl) extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }


}