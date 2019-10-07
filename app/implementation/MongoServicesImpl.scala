package implementation

import javax.inject.Inject
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.Controller
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.play.json.collection.JSONCollection
import service.MongoServices

import scala.concurrent.Future

class MongoServicesImpl @Inject()(val reactiveMongoApi: ReactiveMongoApi) extends Controller
  with MongoController with ReactiveMongoComponents with MongoServices {

  def getCollection(collectionName: String): Future[JSONCollection] = {
    database.map(_.collection[JSONCollection](collectionName))
  }

}
