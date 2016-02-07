name := """Projet Veille Techno"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

lazy val akkaVersion = "2.4.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  "org.webjars" % "font-awesome" % "4.4.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.mongodb" %% "casbah" % "3.1.0",
 // "org.mongodb" % "bson" % "3.2.1",
  //"org.mongodb.scala" % "mongo-scala-bson_2.11" % "1.1.0",
  //"org.mongodb" % "mongodb-driver-core" % "3.2.1",
  //"org.mongodb" % "mongodb-driver-async" % "3.2.1",
  //"org.mongodb.scala" %% "mongo-scala-driver" % "1.1.0",
//  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
//  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  jdbc,
  cache,
  ws,
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
