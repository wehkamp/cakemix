import sbt._
import sbt.Keys._

object Build extends Build {
  import Dependencies._
  import Formatting._

  lazy val basicSettings = Seq(
    organization := "com.xebia",
    version := "0.1.1-SNAPSHOT",
    scalaVersion := "2.11.7",
    scalacOptions := basicScalacOptions,
    incOptions := incOptions.value.withNameHashing(true)
  )

  lazy val libSettings = basicSettings ++ formattingSettings

  lazy val preso = Project("cakemix", file("."))
    .settings(libSettings: _*)
    .settings(libraryDependencies ++=
      compile(
        akkaActor,
        akkaSlf4j,
        ficus
      ) ++
      test(
        scalatest,
        akkaTestkit
      )
    )

  val basicScalacOptions = Seq(
    "-encoding", "utf8",
    "-target:jvm-1.7",
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
