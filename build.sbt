import Formatting._
import Publishing._

name := "cakemix"
organization := "nl.wehkamp.cakemix"
scalaVersion := "2.12.8"
crossScalaVersions := Seq("2.11.12", "2.12.8", "2.13.0-RC2")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

formattingSettings
publishingSettings

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.23" % Provided,
  "com.typesafe" % "config" % "1.3.4" % Provided
)
