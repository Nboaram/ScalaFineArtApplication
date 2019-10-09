package controllers
import javax.inject.Inject

import play.api.i18n._
import play.api.mvc._

class LanguageController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def switchToLanguage(url: String,language: String) = Action { implicit request =>
    Redirect(url).withLang(Lang(language))
  }

}