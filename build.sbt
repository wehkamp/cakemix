import Formatting._
import Publishing._

name := "cakemix"
organization := "nl.wehkamp.cakemix"
scalaVersion := "2.12.8"
crossScalaVersions := Seq("2.11.12", "2.12.8")
scalacOptions := basicScalacOptions
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

formattingSettings
publishingSettings

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.21"

val basicScalacOptions = Seq(
  "-encoding", "utf8",
  "-target:jvm-1.8",
  "-feature",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-unchecked",
  "-deprecation",
  "-Xlog-reflective-calls"
)

val fussyScalacOptions = basicScalacOptions ++ Seq(
  "-Ywarn-unused",
  "-Ywarn-unused-import"
)
