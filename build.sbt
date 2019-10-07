name := "ScalaFineArtApplication"
 
version := "1.0" 
      
lazy val `scalafineartapplication` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test,
  "org.slf4j" % "slf4j-log4j12" % "1.7.25",
  "org.mongodb.scala" %% "mongo-scala-driver" % "2.6.0",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "org.mockito" % "mockito-core" % "2.7.22" % Test
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      