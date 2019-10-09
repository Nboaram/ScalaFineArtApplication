package helpers

import java.awt.image.BufferedImage
import java.io.{ByteArrayInputStream, ByteArrayOutputStream, File}

import javax.imageio.ImageIO

class DataConverter {

  def imageToBinaryData(filename: String): Array[Byte] = {

    val outputStream: ByteArrayOutputStream = new ByteArrayOutputStream()

    ImageIO.write(ImageIO.read(new File(filename)), filename.slice(filename.length - 3, filename.length), outputStream)
    outputStream.toByteArray
  }

  def binaryDataToImage(binaryData: Array[Byte], filename: String) = {

    val byteArrayInputStream :ByteArrayInputStream = new ByteArrayInputStream(binaryData)
    val bufferedImage :BufferedImage = ImageIO.read(byteArrayInputStream)
    ImageIO.write(bufferedImage, filename.slice(filename.length - 3, filename.length), new File(filename))
  }

}
