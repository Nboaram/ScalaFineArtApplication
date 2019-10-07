package models

import javax.inject.Inject

class UserDatabase @Inject()() {
  def lookupUser(u: User): Boolean = {
    //TODO query your database here
    if (u.username == "foo" && u.password == "foo") true else false
  }
}
