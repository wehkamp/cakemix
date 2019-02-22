import sbt.Keys._
import sbtrelease.ReleasePlugin.autoImport._
import bintray.BintrayKeys._

object Publishing {
  lazy val publishingSettings = Seq(
    releaseCrossBuild := true,

    bintrayOrganization := Some("wehkamp"),
    bintrayRepository := "releases",

    pomExtra :=
      <url>https://github.com/wehkamp/cakemix#readme</url>
      <scm>
        <url>git@github.com:wehkamp/cakemix.git</url>
        <connection>scm:git@github.com:wehkamp/cakemix.git</connection>
      </scm>
      <developers>
        <developer>
          <id>agemooij</id>
          <name>Age Mooij</name>
          <url>http://github.com/agemooij</url>
        </developer>
        <developer>
          <id>raboof</id>
          <name>Arnout Engelen</name>
          <url>http://github.com/raboof</url>
        </developer>
      </developers>
    )
}
