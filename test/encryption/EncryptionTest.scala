package encryption

import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import play.api.test.WithApplication
import utils.encryption.Encryption._


@RunWith(classOf[JUnitRunner])
class EncryptionTest extends Specification {
  val data = "Example data"
  "Application" should {
    "encrypt strings of data" in new WithApplication {
      val encryptedData: String = encrypt(data)
      val decryptedData: String = decrypt(encryptedData)
      encryptedData shouldNotEqual data
      decryptedData shouldEqual data
    }
    "hash passwords" in new WithApplication {
      val rawPassword = "password123"
      val hashedPassword: String = hashPassword(rawPassword)

      rawPassword shouldNotEqual hashedPassword
      assert(checkPassword(rawPassword, hashedPassword))
    }
  }
}
