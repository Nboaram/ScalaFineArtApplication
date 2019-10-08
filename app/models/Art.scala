package models

import helpers.GenerateId

import scala.reflect.io.File

case class Art(
                id: Int,
                image: BsonBinary,
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