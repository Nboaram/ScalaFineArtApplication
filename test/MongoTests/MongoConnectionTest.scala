package MongoTests

import org.mongodb.scala
import org.mockito.Mockito
import org.mongodb.scala.{Document, MongoClient, MongoCollection, MongoDatabase}
import org.scalatest.{BeforeAndAfter, FunSuite, Inside, Inspectors, Matchers, OptionValues}
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._
import service.MongoConnection
import helpers.Constants.mongoClientVal

class MongoConnectionTest extends FunSuite with Matchers
  with OptionValues with Inside with Inspectors with MockitoSugar with BeforeAndAfter {

  var mongoConnection: MongoConnection = _
  var mockMongoConnection: MongoConnection = _

  before {
    mongoConnection = new MongoConnection
    mockMongoConnection = mock[MongoConnection]
  }

  test ("The function getClient") {
    when(mockMongoConnection.getClient(mongoClientVal.toString())).thenReturn(MongoClient("mongodb://test"))
    assert(mockMongoConnection.getClient(mongoClientVal.toString()).isInstanceOf[MongoClient])
  }


}
