package helpers

class ImageHandler extends DataConverter {

  //upload image to temp/gallery with name as just art.title
  //will be built into form



 //retrieve image from temp
  def returnTempImageAsByteArray(filename:String): Array[Byte] = {
    imageToBinaryData(Constants.tempImageGalleryLocation.toString, filename)
  }

  //submit artwork to database

  //delete file from temp/gallery



}
