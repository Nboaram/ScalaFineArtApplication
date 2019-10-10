package models

import helpers.GenerateId
import helpers.ImageHandler

//TODO finalise filetype for image and link to file to data converter

case class Art(
                id: Int,
                customerId: Int,
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
    "png",      //TODO getFileType() from form,
    ImageHandler.returnTempImageAsByteArray(Art.idCount + "-" + title + "." + fileType),
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
       |$title $artist
       |$description
       |$artType
       |$genre
       |$movement
       |$original""".stripMargin

}

object Art extends GenerateId {
  var idCount:Int = 0
}