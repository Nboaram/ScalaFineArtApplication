package models

import helpers.GenerateId
import helpers.ImageHandler

//TODO finalise filetype for image and link to file to data converter

case class Art(
                id: Int,
                customerId: Int,
                originalFilename: String,
                fileType: String,
                image: Array[Byte],
                title: String,
                artist: String,
                description: String,
                genre: String,  //TODO link with enum list
                artType: String,  //TODO link with enum list
                movement:String,  //TODO link with enum list
                original: Boolean
              ) {
  def this (
             customerId: Int,
             originalFilename: String,
             fileType: String = "jpg",
             title: String,
             artist: String,
             description: String,
             genre: String,
             artType: String,
             movement:String,
             original: Boolean
           ) = this (
    Art.generateId(),
    customerId: Int,
//TODO get originalFilename directly from appraisal form
    originalFilename: String,

    // file type -->    getFilenameFromAppraisalForm.slice(getFilenameFromAppraisalForm.length-3, getFilenameFromAppraisalForm.length),      //TODO getFileType() from form,
    originalFilename.slice(originalFilename.length-3, originalFilename.length),

    ImageHandler.returnTempImageAsByteArray( filename =originalFilename),
    //    ImageHandler.returnTempImageAsByteArray( filename = Art.idCount + "-" + title + "." + fileType),
    // file name -->    ImageHandler.returnTempImageAsByteArray(filename = getFilenameFromAppraisalForm ), //TODO getFilenameFromAppraisalForm

    title,
    artist,
    description,
    genre,
    artType,
    movement,
    original
  )
  override def toString: String =
    s"""$id
       |$customerId
       |$image
       |Title: $title, Artist: $artist
       |$description
       |$artType
       |$genre
       |$movement
       |$original""".stripMargin

}

object Art extends GenerateId {
  var idCount:Int = 0
}