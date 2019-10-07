package MongoTests

import org.scalatest._
import org.scalatestplus.mockito.MockitoSugar
class BaseTestingClassMongo extends FlatSpec with Matchers
  with OptionValues with Inside with Inspectors with MockitoSugar with BeforeAndAfter {

}
