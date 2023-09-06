inThisBuild(
  Seq(
    scalaVersion := "2.13.11",
    organizationName := "nl.wehkamp.cakemix",
    licenses += License.Apache2,
    publish / skip := true,
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
)

lazy val typesafeConfig = "com.typesafe" % "config" % "1.4.2" % Provided

lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.6.21" % Provided

lazy val pekkoActor = "org.apache.pekko" %% "pekko-actor" % "1.0.1" % Provided

lazy val `cakemix` = (project in file("cakemix"))
  .settings(name := "cakemix")
  .settings(publish / skip := false)
  .settings(libraryDependencies ++= Seq(typesafeConfig, akkaActor))

lazy val `cakemix-pekko` = (project in file("cakemix-pekko"))
  .settings(name := "cakemix-pekko")
  .settings(publish / skip := false)
  .settings(libraryDependencies ++= Seq(typesafeConfig, pekkoActor))
