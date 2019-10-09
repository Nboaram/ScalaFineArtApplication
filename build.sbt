name := "ScalaFineArtApplication"
 
version := "1.0" 
      
lazy val `scalafineartapplication` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test,
  "org.reactivemongo" %% "play2-reactivemongo" % "0.12.5-play25",
  "com.typesafe.play" %% "play" % "2.5.19",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "org.scalactic" %% "scalactic" % "3.0.8",
  "org.mindrot" % "jbcrypt" % "0.4"
)
unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

import com.typesafe.sbt.packager.MappingsHelper._
mappings in Universal ++= directory(baseDirectory.value / "public")