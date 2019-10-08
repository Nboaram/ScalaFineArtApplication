package helpers

import scala.resources.BaseTestingClass

class GenerateIdTest extends BaseTestingClass {


  "The generateId method" should "add one to the count of the object it is called within" in {
    object TestObject extends GenerateId {
      var idCount = 0
    }
    assert(TestObject.generateId() == 1)
  }

"The generateId method" should "add one to the count of the object it is called within, even if the count is very large" in {
  object TestObject extends GenerateId {
    var idCount = 2147483646
  }
  assert(TestObject.generateId() == 2147483647)
}
}


