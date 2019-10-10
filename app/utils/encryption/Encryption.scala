package utils.encryption

import org.mindrot.jbcrypt.BCrypt
import play.api.libs.Crypto

object Encryption {
  val salt = BCrypt.gensalt()
  def hashPassword(password: String): String = BCrypt.hashpw(password, salt)
  def checkPassword(candidate: String, hashedPassword: String): Boolean = BCrypt.checkpw(candidate, hashedPassword)


  def encrypt: String => String = Crypto.encryptAES
  def decrypt: String => String = Crypto.decryptAES
}
