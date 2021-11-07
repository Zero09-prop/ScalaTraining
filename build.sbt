name := "ScalaTraining"

version := "0.1"

scalaVersion := "2.13.6"

val circeVersion = "0.14.1"


libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

libraryDependencies += "javax.mail" % "javax.mail-api" % "1.6.2"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.0"

