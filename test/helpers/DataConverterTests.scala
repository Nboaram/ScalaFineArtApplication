package helpers

import scala.resources.BaseTestingClass
import utils.constants.TestConstants._

class DataConverterTests extends BaseTestingClass{

  var dataConverter: DataConverter = _

  before {
    dataConverter = new DataConverter
  }

  "imageToBinaryData function" should "return the datatype Array[Byte]" in {
    assert(dataConverter.imageToBinaryData(imageJPEGLocation + imageJPEGFilename).isInstanceOf[Array[Byte]])
  }

  "imageToBinary function" should "be able to accept jpeg and png filetypes" in {
    assert(dataConverter.imageToBinaryData(imagePNGLocation + imagePNGFilename).isInstanceOf[Array[Byte]])
    assert(dataConverter.imageToBinaryData(imageJPEGLocation + imageJPEGFilename).isInstanceOf[Array[Byte]])

  }

  "binaryDataToImage" should "return an image file" in {
    assert(dataConverter.binaryDataToImage(dataConverter.imageToBinaryData(imageJPEGLocation + imageJPEGFilename), imageJPEGLocation, imageJPEGFilename) == true)
    assert(dataConverter.binaryDataToImage(dataConverter.imageToBinaryData(imagePNGLocation + imagePNGFilename), imagePNGLocation, imagePNGFilename) == true)

  }

}
