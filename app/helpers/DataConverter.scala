package helpers

import java.awt.image.BufferedImage
import java.io.{ByteArrayOutputStream, File}

import javax.imageio.ImageIO

class DataConverter {

  def imageToBinaryData(filename:String): Array[Byte] = {

    val image: BufferedImage = ImageIO.read(new File(filename))

    val outputStream: ByteArrayOutputStream = new ByteArrayOutputStream()

    ImageIO.write(image, filename.slice(filename.length-3, filename.length), outputStream)

    val imageByteArray = outputStream.toByteArray

    imageByteArray
  }

}
