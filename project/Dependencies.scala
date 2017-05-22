import sbt.Keys._
import sbt._

object Dependencies {

  lazy val dependencySettings = Seq(
    resolvers += Resolver.jcenterRepo
  )

  val akkaVersion  = "2.5.1"

  val akkaActor     = "com.typesafe.akka"  %% "akka-actor"       % akkaVersion
  val akkaSlf4j     = "com.typesafe.akka"  %% "akka-slf4j"       % akkaVersion

  val ficus         = "com.iheart"         %% "ficus"            %  "1.4.0"

  val akkaTestkit   = "com.typesafe.akka"  %% "akka-testkit"     % akkaVersion
  val scalatest     = "org.scalatest"      %% "scalatest"        % "3.0.1"

  def compile   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def provided  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def test      (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")
  def runtime   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "runtime")
  def container (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "container")
}
