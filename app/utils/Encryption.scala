package utils

import org.mindrot.jbcrypt.BCrypt

object Encryption {
  def hashPassword(pw: String): String = BCrypt.hashpw(pw, BCrypt.gensalt())
  def checkPassword(candidate: String, hashedPassword: String): Boolean = BCrypt.checkpw(candidate, hashedPassword)
}
