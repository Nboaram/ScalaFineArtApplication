package mongoServicesTest

import implementation.MongoServicesImpl
import org.scalatest._
import org.scalatestplus.mockito.MockitoSugar
import play.modules.reactivemongo.ReactiveMongoApi
import org.mongodb.scala._
import org.mockito.Mockito._
import org.mockito.ArgumentMatchersSugar.Any

class MongoServicesTest extends FlatSpec  with OptionValues with Inside with Inspectors with
  MockitoSugar with BeforeAndAfter {

  val reactiveMongoApi = mock[ReactiveMongoApi]
  val mongoServicesImpl=new MongoServicesImpl(reactiveMongoApi)
  "The function getCollection" should "return a collection" in {
    val mockCollection: com.mongodb.async.client.MongoCollection[Document] = mock[com.mongodb.async.client.MongoCollection[Document]]
    //val test: MongoCollection[Document] = mock[MongoCollection[Document]]

    when(mongoServicesImpl.getCollection("test")).thenReturn(new MongoCollection[Document](mockCollection))
    assert(mongoServicesImpl.getCollection("test").isInstanceOf[MongoCollection[Document]])
  }
}
