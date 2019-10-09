package models.Interests

object ArtMovement extends Enumeration {
  type ArtMovement = Value
  val Impressionism, Cubism, Contemporary, Fauvism, Expressionism, Dadaism, Surrealism, Realism, Abstract, Memes = Value
  val PostImpressionism: ArtMovement.Value = Value("Post-Impressionism")
  val PopArt: ArtMovement.Value = Value("Pop Art")

  def main(args:Array[String]): Unit ={
    ArtMovement.values.foreach(println(_))
    val interests:Array[ArtMovement.Value] = Array(ArtMovement.Abstract,ArtMovement.Cubism)
    interests.foreach(interest => println(s"I like $interest"))
  }
}
