package helpers

import scala.resources.BaseTestingClass

class DataConverterTests extends BaseTestingClass{

  val imageJPEG = "test/scala/resources/testImages/test.jpg"
  val imagePNG = "test/scala/resources/testImages/test1.png"

  var dataConverter: DataConverter = _

  before {
    dataConverter = new DataConverter
  }

  "imageToBinaryData function" should "return the datatype Array[Byte]" in {
    assert(dataConverter.imageToBinaryData(imageJPEG).isInstanceOf[Array[Byte]])
  }

  "imageToBinary function" should "be able to accept jpeg and png filetypes" in {
    assert(dataConverter.imageToBinaryData(imagePNG).isInstanceOf[Array[Byte]])
    assert(dataConverter.imageToBinaryData(imageJPEG).isInstanceOf[Array[Byte]])

  }

  "binaryDataToImage" should "return an image file" in {
    val binDataJPEG = dataConverter.imageToBinaryData(imageJPEG)
    val filenameJPEG = "test.jpg"
    val binDataPNG = dataConverter.imageToBinaryData(imageJPEG)
    val filenamePNG = "test1.png"
    assert(dataConverter.binaryDataToImage(binDataJPEG, filenameJPEG) == true)
    assert(dataConverter.binaryDataToImage(binDataPNG, filenamePNG) == true)


  }

}
