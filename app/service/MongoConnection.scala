package service
import org.mongodb.scala.{MongoClient, MongoCollection, MongoDatabase}

class MongoConnection {

  def getClient(client: String) = {
    MongoClient(client)
  }

}
