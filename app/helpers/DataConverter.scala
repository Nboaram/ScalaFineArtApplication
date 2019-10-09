package helpers

import java.io.{ByteArrayOutputStream, File}

import javax.imageio.ImageIO

class DataConverter {

  def imageToBinaryData(filename:String): Array[Byte] = {

    val outputStream: ByteArrayOutputStream = new ByteArrayOutputStream()

    ImageIO.write(ImageIO.read(new File(filename)), filename.slice(filename.length-3, filename.length), outputStream)
    outputStream.toByteArray
  }

}
