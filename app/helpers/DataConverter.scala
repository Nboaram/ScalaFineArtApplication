package helpers

import java.awt.image.BufferedImage
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

  def binaryDataToImage(binaryData: Array[Byte], filename: String):Boolean = {

    val imageLocation = "C:/Users/Admin/IdeaProjects/ScalaFineArtApplication/test/scala/resources/testImages/"

    val byteArrayInputStream :ByteArrayInputStream = new ByteArrayInputStream(binaryData)
    val bufferedImage :BufferedImage = ImageIO.read(byteArrayInputStream)
    ImageIO.write(bufferedImage, filename.slice(filename.length - 3, filename.length), new File(imageLocation + filename))
  }

}
