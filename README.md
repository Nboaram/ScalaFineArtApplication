### Internationalisation

The languages available are selected in the `application.conf` file
```
play.i18n.langs=["en","cy"]
```
here we have selected English and Welsh.

In the `conf` package you will see two files, one called `messages.cy` and another called `messages.en`. In each file you will
see a value called `header.gallery`, from here on this type of value will be referred to as a message val. In the `en` file it is the word Gallery while in the `cy` file it is the word Gallery translated
into Welsh. To do **ANY TRANSLATION** you need the original value in a message value and the translated version in a message value. For example, say
we have a page hiworld, in the `messages.en` file we would need
```
hiworld.hello=Hello, World!
```
and in the `messages.cy` file we would need
```
hiworld.hello=Helo, Byd!
```
This value `hiworld.hello` would be referenced to in a hiworld.scala.html file with `@messages(hiworld.hello)` where the text should be (i.e in a div tag). Be careful when using punctionation, as there are errors with this.

The hiworld file would need `@()(implicit messages: Messages, lang: Lang)` at the top. The Messages API is put into the @Inject of the controller where the page is loaded
`messagesApi: MessagesApi` and needs a `wtih I18nSupport` extension. The lang is also put into the inject of the controller `langs: Lang`.

The controller used to generate the page would also need would need a `implicit request => request...` (see conroller application.index) (**NOT SURE ABOUT THIS**)

The language is changed via a method in the `LanguageController` file given by
```
  def switchToLanguage(url: String,language: String)
```
This will REDIRECT the page to the given URL and set the language as the string provided (should be '"cy"' for Welsh and `"en"` for english).

#### CONCERNING THE Â SYMBOL IN WELSH

This is a compiler problem, not a programming problem. It is the way the files are encoded.

In your Intellij hit the keys `ctrl+alt+s` buton. Go to Editor, then File Encodings. Change the property for `Default encoding for properties files` to UTF-8. This should solve the problem. See the following image

![Alt Text](/readmeImages/changeSetEncod.PNG)
