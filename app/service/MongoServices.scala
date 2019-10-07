package service

import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.Future

trait MongoServices {
  def getCollection(collectionName: String): Future[JSONCollection]
}
