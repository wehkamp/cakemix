import sbt._
import sbt.Keys._

object Build extends Build {
  import Formatting._
  import Publishing._

  lazy val basicSettings = Seq(
    organization := "com.xebia",
    scalaVersion := "2.12.2",
    crossScalaVersions := Seq("2.11.11", "2.12.2"),
    scalacOptions := basicScalacOptions,
    incOptions := incOptions.value.withNameHashing(true),
    licenses := Seq("The MIT License (MIT)" -> url("http://opensource.org/licenses/MIT"))
  )

  lazy val libSettings = basicSettings ++ formattingSettings ++ publishingSettings

  lazy val preso = Project("cakemix", file("."))
    .settings(libSettings: _*)
    .settings(libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.3")

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
}
