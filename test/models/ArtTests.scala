package models

import scala.reflect.io.File
import scala.resources.BaseTestingClass

class ArtTests extends BaseTestingClass {

  var art: Art = _

  "Art.generateId()" should "Add 1 to the current count and return the new value" in {
    Art.idCount = 123
    assert(Art.generateId() == 124)
  }

  "A developer" should "be able to use the Art constructor to generate an Art Object" in {
    val artTest = new Art(File("C:/Users/Admin/IdeaProjects/ScalaFineArtApplication/public/images/favicon.png"),
      "Test Art",
      "Test Artist",
      "This is a test description",
      "Test Category",
      true)

    println(artTest)
  }



}
