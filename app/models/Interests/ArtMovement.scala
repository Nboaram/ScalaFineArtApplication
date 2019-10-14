package models.Interests

object ArtMovement extends Enumeration {
  type ArtMovement = Value
  val Impressionism, Cubism, Contemporary, Fauvism, Expressionism, Dadaism, Surrealism, Realism, Memes = Value
  val PostImpressionism: ArtMovement.Value = Value("Post-Impressionism")
  val PopArt: ArtMovement.Value = Value("Pop Art")
}
