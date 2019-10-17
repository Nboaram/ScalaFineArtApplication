import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import play.api.test.WithApplication
import utils.constants.TestConstants
import utils.encryption.Encryption._


class EncryptionSpec extends Specification {
  val address: String = TestConstants.fakeAddress.toString
  "Encryption" should {
    "encrypt strings of data" in new WithApplication {
      val encryptedAddress: String = encrypt(address)
      val decryptedAddress: String = decrypt(encryptedAddress)
      encryptedAddress shouldNotEqual address
      decryptedAddress shouldEqual address
    }
    "hash passwords" in new WithApplication {
      val rawPassword: String = TestConstants.fakePassword.toString
      val hashedPassword: String = hashPassword(rawPassword)

      rawPassword shouldNotEqual hashedPassword
      assert(checkPassword(rawPassword, hashedPassword))
    }
  }
}
