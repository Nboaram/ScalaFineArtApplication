package helpers

object Constants extends Enumeration {

  val contactUrl: Value = Value("/contact")
  val accountUrl: Value = Value("/account")
  val appraisalUrl: Value = Value("/appraisal")
  val checkoutUrl: Value = Value("/checkout")
  val galleryUrl: Value = Value("/gallery")
  val loginUrl: Value = Value("/login")
  val registerUrl: Value = Value("/register")
  val viewUrl: Value = Value("/view")

  val text_html: Value = Value("text/html")

  val localHost: Value = Value("localhost")
  val insertedDocument: Value = Value("inserted document: ")
  val removedDocument: Value = Value("removed document: ")
  val username: Value = Value("username")
  val email: Value = Value("email")
  val firstName: Value = Value("firstName")
  val lastName: Value = Value("lastName")
  val password: Value = Value("password")
  val emptyString: Value = Value("")
  val admin: Value = Value("admin")
  val steps: Value = Value("steps")
  val title: Value = Value("title")
  val recipes: Value = Value("recipes")
  val loginDetails: Value = Value("loginDetails")
  val created: Value = Value("created")
  val login: Value = Value("login")
  val loginMessage: Value = Value("You have successfully logged in")
  val signUp: Value = Value("signUp")
  val signUpMessage: Value = Value("You have successfully signed up")
  val signUpConstraint: Value = Value("Unique username")
  val signUpInvalid: Value = Value("Username is taken")
  val indexString: Value = Value("Your new application is ready.")
  val id: Value = Value("id")

}