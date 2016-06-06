import sbt._
import sbt.Keys._

object Dependencies {
  val akkaVersion  = "2.4.7"

  val akkaActor     = "com.typesafe.akka"  %% "akka-actor"       % akkaVersion
  val akkaSlf4j     = "com.typesafe.akka"  %% "akka-slf4j"       % akkaVersion

  val ficus         = "net.ceedubs"        %% "ficus"            % "1.1.1"

  val akkaTestkit   = "com.typesafe.akka"  %% "akka-testkit"     % akkaVersion
  val scalatest     = "org.scalatest"      %% "scalatest"        % "2.2.2"

  def compile   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def provided  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def test      (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")
  def runtime   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "runtime")
  def container (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "container")
}
