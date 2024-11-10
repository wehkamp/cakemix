ThisBuild / organization := "nl.wehkamp"
ThisBuild / publish / skip := true

lazy val commonSettings = Seq(
  scalaVersion := "2.13.15",
  crossScalaVersions += "3.3.4",
  scalacOptions ++= (CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 13)) => Seq("-Xsource:3")
    case _             => Seq.empty[String]
  }),
  licenses += License.Apache2,
  homepage := Some(url("https://github.com/wehkamp/cakemix")),
  publish / skip := false,
  developers := List(
    Developer(
      id = "agemooij",
      name = "Age Mooij",
      email = "",
      url = url("https://github.com/agemooij")
    ),
    Developer(
      id = "raboof",
      name = "Arnout Engelen",
      email = "",
      url = url("https://github.com/raboof")
    )
  )
)

lazy val typesafeConfig = "com.typesafe" % "config" % "1.4.3" % Provided

lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.6.21" % Provided

lazy val pekkoActor = "org.apache.pekko" %% "pekko-actor" % "1.1.2" % Provided

lazy val `cakemix-akka` = (project in file("cakemix-akka"))
  .settings(name := "cakemix-akka")
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(typesafeConfig, akkaActor))

lazy val `cakemix-pekko` = (project in file("cakemix-pekko"))
  .settings(name := "cakemix-pekko")
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(typesafeConfig, pekkoActor))

