package controllers

import helpers.Constants
import implementation.MongoServicesImpl
import javax.inject.Inject
import models.Recipe
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import play.api.mvc.{Action, AnyContent, Controller}

import scala.concurrent.Future


class ExampleController @Inject()(val mongoServicesImpl: MongoServicesImpl) extends Controller {



}
