package helpers

trait GenerateId {
  var idCount: Int
  def generateId(): Int = {
    idCount += 1
    idCount
  }
}
