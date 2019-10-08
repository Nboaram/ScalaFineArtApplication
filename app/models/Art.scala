package models

import java.awt.image.BufferedImage

import helpers.GenerateId

case class Art(
                id: Int,
                image: BufferedImage,
                title: String,
                artist: String,
                description: String,
                category: String, //TODO create enum list for different categories
                original: Boolean
              ) {
  def this (
             image: BufferedImage,
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
  var idCount = 0
}