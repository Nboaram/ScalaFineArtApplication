package models.Interests

import java.io

import models.SignUp
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

//
//object InterestLists{
////  val artTypeForm: Form[List[ArtType.Value]] = Form(
////    mapping(
////      ArtType.Drawings.toString -> boolean,
////      ArtType.Paintings.toString -> boolean,
////      ArtType.Photographs.toString -> boolean,
////      ArtType.Prints.toString -> boolean,
////      ArtType.Sculptures.toString -> boolean
////    )()
////  )
//
//  def apply[T](listElements:T*):List[T]=listElements.toList
//  def unapplySeq[T](list: Seq[T]):Option[String]= list match {
//  case list:Seq[ArtType] => Some(listToString(list))
//  case list:Seq[ArtGenre] => Some(listToString(list))
//  case list:Seq[ArtMovement] => Some(listToString(list))
//  case _ => None
//  }
//  def listToString[T](list:Seq[T], string:String=""):String = {
//    if (list.isEmpty) ""
//    else list.head.toString + listToString(list.tail)
//  }
//  def main(args:Array[String]):Unit = {
//    var x = InterestLists(ArtType.Paintings)
//    println(InterestLists.unapplySeq(x))
//    x = x :+ ArtType.Drawings
//    println(InterestLists.unapplySeq(x))
//    x = x :+ ArtType.Paintings
//    println(InterestLists.unapplySeq(x))
//    x = x :+ ArtType.Prints
//    println(InterestLists.unapplySeq(x))
//    val loginForm = Form(
//      ArtType.values.map(value=> (value.toString, boolean):_*
//    )
//    val allTypes = ArtType.values.map(value=> value.toString -> "true").toMap
//    println(allTypes)
//    val anyData = Map(ArtType.Sculptures.toString -> "true")
//    val user2 = loginForm.bind(anyData).get
//    println(user2)
//    val user3 = loginForm.bind(allTypes)
//    println(user3)
//
//  }
//}