package helpers

import scala.resources.BaseTestingClass

class DataConverterTests extends BaseTestingClass{

  var dataConverter: DataConverter = _

  before {
    dataConverter = new DataConverter
  }

  "imageToBinaryData function" should "return the datatype Array[Byte]" in {
    val filename = "C:/Users/Admin/IdeaProjects/ScalaFineArtApplication/public/images/favicon.png"
    assert(dataConverter.imageToBinaryData(filename).isInstanceOf[Array[Byte]])
  }


}
