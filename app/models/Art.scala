package models

import helpers.GenerateId

import scala.reflect.io.File

//TODO finalise filetype for image and link to file to data converter

case class Art(
                id: Int,
                image: File,
                title: String,
                artist: String,
                description: String,
                genre: String,  //TODO link with enum list
                artType: String,  //TODO link with enum list
                movement:String,  //TODO link with enum list
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