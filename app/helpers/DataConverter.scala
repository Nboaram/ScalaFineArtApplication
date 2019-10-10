package helpers

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, File}

import javax.imageio.ImageIO

class DataConverter {

  //TODO finalise input type for imageToBinaryData

  def imageToBinaryData(filename: String): Array[Byte] = {

    val outputStream: ByteArrayOutputStream = new ByteArrayOutputStream()

    ImageIO.write(ImageIO.read(new File(filename)), filename.slice(filename.length - 3, filename.length), outputStream)
    outputStream.toByteArray
  }

  //TODO change location of created file to cache

  def binaryDataToImage(binaryData: Array[Byte], fileLocation: String,  filename: String):Boolean = {

    //val imageLocation = "test/utils/constants/testImages/"
    val byteArrayInputStream :ByteArrayInputStream = new ByteArrayInputStream(binaryData)
    ImageIO.write(ImageIO.read(byteArrayInputStream), filename.slice(filename.length - 3, filename.length), new File(fileLocation + filename))
  }
}
