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

  "imageToBinary function" should "be able to accept jpeg and png filetypes" in {
    val png = "C:/Users/Admin/IdeaProjects/ScalaFineArtApplication/public/images/favicon.png"
    val jpeg = "C:\\Users\\Admin\\IdeaProjects\\ScalaFineArtApplication\\test\\scala\\resources\\testImages\\test.jpg"
    assert(dataConverter.imageToBinaryData(png).isInstanceOf[Array[Byte]])
    assert(dataConverter.imageToBinaryData(jpeg).isInstanceOf[Array[Byte]])

  }

  "binaryDataToImage" should "return an image file" in {
    val image = "C:/Users/Admin/IdeaProjects/ScalaFineArtApplication/public/images/favicon.png"
    val binData = dataConverter.imageToBinaryData(image)

    assert(dataConverter.binaryDataToImage(binData, "test1.png") == true)

  }

}
