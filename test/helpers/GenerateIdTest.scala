package helpers

import scala.resources.BaseTestingClass

class GenerateIdTest extends BaseTestingClass {

  object TestObject extends GenerateId {
    var idCount = 0
    generateId()
  }

  "The generateId method" should "add one to the count of the object it is called within" in {
    assert(TestObject.generateId() == 1)
  }

}
