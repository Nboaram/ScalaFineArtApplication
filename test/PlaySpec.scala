import org.specs2.concurrent.ExecutionEnv

import scala.concurrent.{ExecutionContext, Future}
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.test.Helpers.running
import play.modules.reactivemongo.{CollectionResolution, NamedDatabase, ReactiveMongoApi, ReactiveMongoApiFromContext, WithCollection}


final class PlaySpec(implicit ee: ExecutionEnv)
  extends org.specs2.mutable.Specification {



}
