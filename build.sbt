import Formatting._
import Publishing._

name := "cakemix"
organization := "nl.wehkamp.cakemix"
scalaVersion := "2.12.13"
crossScalaVersions := Seq("2.11.12", "2.12.13", "2.13.6")

licenses += ("Apache-2.0", url("https://opensource.org/licenses/Apache-2.0"))

formattingSettings
publishingSettings

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.32" % Provided,
  "com.typesafe" % "config" % "1.4.1" % Provided
)
