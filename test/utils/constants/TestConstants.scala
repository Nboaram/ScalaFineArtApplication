package utils.constants

import models.Art

object TestConstants extends Enumeration {
  val fakePassword: Value = Value("password123")
  val fakeAddress: Value = Value("123 Example Address")
  val imageJPEGLocation = "test/utils/constants/testImages/"
  val imagePNGLocation = "test/utils/constants/testImages/"
  val imageJPEGFilename = "test.jpg"
  val imagePNGFilename = "test1.png"
  val TestArtwork = new Art(
    1,
    "Test Title",
    "Test Artist",
    "This is a test description",
    "Test Genre",
    "Test Art Type",
    "Test Movement",
    true
  )

}
