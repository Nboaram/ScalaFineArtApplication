package controllers

import java.io.File

import play.api.cache._
import play.api.mvc._
import javax.inject.Inject

class ArtCacheController @Inject() (@NamedCache("art-cache") artCache: CacheApi) extends Controller{

  def imageToCache(imageId: String, imageFile: File) = Action {
    Ok(artCache.set(imageId, imageFile ))
  }
}
