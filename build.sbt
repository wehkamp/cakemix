lazy val commonSettings = Seq(
  organization := "nl.wehkamp.cakemix",
  scalaVersion := "2.13.11",
  licenses += License.Apache2,
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

lazy val typesafeConfig = "com.typesafe" % "config" % "1.4.2" % Provided

lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.6.21" % Provided

lazy val `cakemix-akka` = (project in file("cakemix"))
  .settings(name := "cakemix")
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(typesafeConfig, akkaActor))
