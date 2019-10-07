package service

import helpers.Constants
import javax.inject.Inject
import play.api.mvc.{Action, Controller}
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.play.json.collection.JSONCollection
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.Json
import reactivemongo.play.json._

import scala.concurrent.Future

class MongoServices @Inject()(val reactiveMongoApi: ReactiveMongoApi) extends Controller
  with MongoController with ReactiveMongoComponents {

  def getCollection(collectionName: String): Future[JSONCollection] = {
    database.map(_.collection[JSONCollection](collectionName))
  }

}
