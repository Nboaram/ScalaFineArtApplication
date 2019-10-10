package helpers

import java.io.File

 object ImageHandler extends DataConverter {

  //upload image to temp/gallery with name as just art.title
  //will be built into form



 //retrieve image from temp
  def returnTempImageAsByteArray(filename:String): Array[Byte] = {
    imageToBinaryData(Constants.tempImageGalleryLocation.toString, filename)
  }

  //submit artwork to database
   //will be done on submit of apraisal form

  //delete file from temp/gallery
  def deleteTempImageFile(filename: String) = {
    new File(Constants.tempImageGalleryLocation.toString + filename).delete()
  }

  //get artwork from database and save to public/gallery as (art.id + art title)




}
