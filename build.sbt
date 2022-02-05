name := "cakemix"
organization := "nl.wehkamp.cakemix"
scalaVersion := "2.12.15"
crossScalaVersions := Seq("2.11.12", "2.12.15", "2.13.8")

licenses += ("Apache-2.0", url("https://opensource.org/licenses/Apache-2.0"))

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
