//package models.Interests
//
//import ArtGenre.ArtGenre
//import ArtMovement.ArtMovement
//import ArtType.ArtType
//import helpers._
//import play.api.data.Forms._
//
//case class Interests(artType:List[ArtType.Value], artGenre:List[ArtGenre.Value], artMovements:List[ArtMovement.Value])
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
