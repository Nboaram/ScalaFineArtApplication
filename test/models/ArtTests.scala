package models

import scala.resources.BaseTestingClass

class ArtTests extends BaseTestingClass {

  var art: Art = _

  "Art.generateId()" should "Add 1 to the current count and return the new value" in {
    Art.idCount = 123
    assert(Art.generateId() == 124)
  }

  "A developer" should "be able to use the Art constructor to generate an Art Object" in {

    //println(artTest)
  }



}
