package models.Interests

import play.api.data.Form
import play.api.data.Forms._
import scala.collection.mutable

case class Interests(artType:List[String], artGenre:List[String], artMovements:List[String])
object  Interests{
  val interestsForm: Form[Interests] = Form(
    mapping(
      "artType" -> list(text),
      "artGenre" -> list(text),
      "artMovement" -> list(text)
    )(Interests.apply)(Interests.unapply)
  )
  //TODO Change this to use database
  val interestsDatabase: mutable.Map[String,Interests] =
    mutable.Map("Fab" -> Interests(List(""), ArtGenre.values.map(value=>value.toString).toList, List("")))
  def addElement(username:String, interests: Interests):Unit = {
    Interests.interestsDatabase += (username -> interests)
    for (elem <- interestsDatabase) {println(elem)}
  }
}