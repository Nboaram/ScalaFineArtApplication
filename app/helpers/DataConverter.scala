package helpers

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, File}

import javax.imageio.ImageIO

abstract class DataConverter {

  //TODO finalise input type for imageToBinaryData

  def imageToBinaryData(fileLocation: String, filename: String): Array[Byte] = {

    val outputStream: ByteArrayOutputStream = new ByteArrayOutputStream()

    ImageIO.write(ImageIO.read(new File(fileLocation + filename)), filename.slice(filename.length - 3, filename.length), outputStream)
    outputStream.toByteArray
  }

  //TODO change location of created file to cache

  def binaryDataToImage(binaryData: Array[Byte], fileLocation: String,  filename: String):Boolean = {

    //val imageLocation = "test/utils/constants/testImages/"
    val byteArrayInputStream :ByteArrayInputStream = new ByteArrayInputStream(binaryData)
    ImageIO.write(ImageIO.read(byteArrayInputStream), filename.slice(filename.length - 3, filename.length), new File(fileLocation + filename))
  }
}
