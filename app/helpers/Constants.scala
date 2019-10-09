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
  val space: Value = Value(" ")
  val localHost: Value = Value("localhost")
  val username: Value = Value("username")
  val firstName: Value = Value("firstName")
  val lastName: Value = Value("lastName")
  val password: Value = Value("password")
  val emptyString: Value = Value("")
  val admin: Value = Value("admin")
  val title: Value = Value("title")
  val loginDetails: Value = Value("loginDetails")
  val created: Value = Value("created")
  val login: Value = Value("login")
  val loginMessage: Value = Value("You have successfully logged in")
  val id: Value = Value("id")
  val email: Value = Value("email")
  val signUp: Value = Value("signUp")
  val signUpMessage: Value = Value("You have successfully signed up")
  val signUpConstraint: Value = Value("Unique username")
  val signUpInvalid: Value = Value("Username is taken")
  val indexString: Value = Value("Your new application is ready")
  val failed: Value = Value("failed")
  val incorrectUsername: Value = Value("Incorrect username or password")

}