package MongoTests

import org.mongodb.scala
import org.mockito.Mockito
import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}
import org.scalatest.{BeforeAndAfter, FlatSpec, FunSuite, Inside, Inspectors, Matchers, OptionValues}
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._
import service.MongoServices
import play.modules.reactivemongo.ReactiveMongoApi

class MongoServicesTest extends BaseTestingClassMongo  {

  before {
    val reactiveMongoApi = mock[ReactiveMongoApi]
    val mongoServices = new MongoServices(reactiveMongoApi)
  }

  "The function getCollection" should "return a collection" in {
    val mockCollection: com.mongodb.async.client.MongoCollection[Document] = mock[com.mongodb.async.client.MongoCollection[Document]]
    when(mongoServices.getCollection("test")).thenReturn(new MongoCollection[Document](mockCollection))
  }

}
