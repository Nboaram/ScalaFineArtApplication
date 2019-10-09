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
                category: String, //TODO create enum list for different categories
                original: Boolean
              ) {
  def this (
             image: File,
             title: String,
             artist: String,
             description: String,
             category: String,
             original: Boolean
           ) = this (
    Art.generateId(), //TODO create object and trait for generate ID functionality
    image,
    title,
    artist,
    description,
    category,
    original
  )
  override def toString: String =
    s"""$id
       |$title $artist
       |$description
       |$category
       |$original""".stripMargin

}

object Art extends GenerateId {
  var idCount:Int = 0
}