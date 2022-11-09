name := "cakemix"
organization := "nl.wehkamp.cakemix"
scalaVersion := "2.13.10"
crossScalaVersions := Seq("2.11.12", "2.12.17", "2.13.10")

licenses += License.Apache2

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
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.32" % Provided,
  "com.typesafe" % "config" % "1.4.2" % Provided
)
