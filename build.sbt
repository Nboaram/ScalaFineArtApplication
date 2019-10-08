name := "ScalaFineArtApplication"
 
version := "1.0" 
      
lazy val `scalafineartapplication` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test,
  "org.slf4j" % "slf4j-log4j12" % "1.7.25",
  "org.reactivemongo" %% "play2-reactivemongo" % "0.12.5-play25"
)

// https://mvnrepository.com/artifact/com.typesafe.play/play
libraryDependencies += "com.typesafe.play" %% "play" % "2.5.19"


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

// https://mvnrepository.com/artifact/org.mindrot/jbcrypt
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.4"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"


      