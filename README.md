# cakemix

[![build](https://github.com/wehkamp/cakemix/workflows/build/badge.svg)](https://github.com/wehkamp/cakemix/actions/workflows/scala.yml?query=workflow%3Abuild+branch%3Amain)
![Current Version](https://img.shields.io/badge/version-2.1.0-brightgreen.svg?style=flat "2.1.0")
[![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-blue.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat "Apache 2.0")](LICENSE)

Scala micro-lib containing handy mixin traits for building Akka or Apache Pekko applications

## Setup

Cakemix is published for Scala 2.13 and 3. To start using it add the following to your `build.sbt` for Akka:

    libraryDependencies += "nl.wehkamp" %% "cakemix-akka" % "2.1.0"

or the following for Apache Pekko:

    libraryDependencies += "nl.wehkamp" %% "cakemix-pekko" % "2.1.0"

Note that the group id has changed from `com.xebia` via `nl.wehkamp.cakemix` to `nl.wehkamp`.

## License
The code is available under the [Apache 2.0 License](LICENSE).
