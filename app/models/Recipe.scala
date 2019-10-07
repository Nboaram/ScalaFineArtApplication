package models

import helpers.Constants
import play.api.data._
import play.api.data.Forms._

case class Recipe(id: Option[String] = None,title: String, steps: String)

object Recipe {

  val recipeForm = Form(
    mapping(
      Constants.id.toString -> optional(nonEmptyText),
      Constants.title.toString -> nonEmptyText,
      Constants.steps.toString -> nonEmptyText
    )(Recipe.apply)(Recipe.unapply)
  )

}