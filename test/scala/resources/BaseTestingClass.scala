package scala.resources

import org.scalatest._
import org.scalatestplus.mockito.MockitoSugar

abstract class BaseTestingClass extends FlatSpec with Matchers with OptionValues with Inside with Inspectors with
  MockitoSugar with BeforeAndAfter