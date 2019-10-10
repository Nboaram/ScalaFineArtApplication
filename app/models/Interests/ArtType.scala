package models.Interests

class ArtType{
  val artTypeChoices:List[(ArtType.Value, Boolean)] = ArtType.values.map(value => (value, false)).toList
  def apply(artType: ArtType.Value*):List[(ArtType.Value, Boolean)]={
    artTypeChoices.map(value => if (artType.contains(value._1)) (value._1, true) else value)
  }
}
object ArtType extends Enumeration {
  type ArtType = Value
  val Paintings, Sculptures, Prints, Drawings, Photographs = Value
}
