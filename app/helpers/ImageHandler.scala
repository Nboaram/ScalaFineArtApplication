package helpers

import java.io.File

 object ImageHandler extends DataConverter {

  //upload image to temp/gallery with name as just art.title
  //will be built into form



 //retrieve image from temp
  def returnTempImageAsByteArray(fileLocation: String = Constants.tempImageGalleryLocation.toString, filename: String): Array[Byte] = {
    imageToBinaryData(fileLocation, filename)
  }

  //submit artwork to database
   //will be done on submit of apraisal form

  //delete file from temp/gallery
  def deleteTempImageFile(fileLocation: String = Constants.tempImageGalleryLocation.toString, filename: String) = {
    new File(fileLocation + filename).delete()
  }

  //get artwork from database and save to public/gallery as (art.id + art title)




}
