name := "ScalaFineArtApplication"
 
version := "1.0" 
      
lazy val `scalafineartapplication` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"


libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test )

// https://mvnrepository.com/artifact/com.typesafe.play/play
libraryDependencies += "com.typesafe.play" %% "play" % "2.5.19"


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

// https://mvnrepository.com/artifact/org.mindrot/jbcrypt
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.4"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"


      