package authentication

import play.api.mvc.{Request, WrappedRequest}

class AuthenticatedRequest[A](val username: String, val request: Request[A]) extends WrappedRequest[A](request)