package models.Interests

object ArtGenre extends Enumeration {
  type ArtGenre = Value
  val Abstract, Cityscape, Genre, Illustration, Landscape, Nude, Portrait, Religious = Value
  val SketchAndStudy: ArtGenre.Value = Value("Sketch and Study")
  val StillLife: ArtGenre.Value = Value("Still Life")
}
