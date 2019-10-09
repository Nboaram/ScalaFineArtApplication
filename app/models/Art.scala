package models

import helpers.GenerateId

import scala.reflect.io.File

//TODO image to bindata conversion. Create an external function to do this https://medium.com/tech-and-the-city/from-image-to-bytes-and-back-again-563abc5c1412

case class Art(
                id: Int,
                image: File,
                title: String,
                artist: String,
                description: String,
                genre: String,  //TODO create enum list for different categories
                artType: String,  //TODO create enum list for different categories
                movement:String,  //TODO create enum list for different categories
                original: Boolean
              ) {
  def this (
             image: File,
             title: String,
             artist: String,
             description: String,
             genre: String,
             artType: String,
             movement:String,
             original: Boolean
           ) = this (
    Art.generateId(), //TODO create object and trait for generate ID functionality
    image,
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