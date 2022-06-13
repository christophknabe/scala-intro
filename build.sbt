// (C) 2022-06-13 Christoph Knabe
// SBT is the mainly used Scala Build Tool. See https://www.scala-sbt.org/
// It follows the tradition of Java Maven and Groovy Gradle.
// The syntax of a build script is Scala. So we can define our names:
val scalaV = "2.12.15"
// Mostly you define a value for a key, which configures the build tool.
//Header configuration for the project as a whole:
// with which Scala version we compile+run
scalaVersion := scalaV
// the version number we give to our artifact
version := "1.0-SNAPSHOT"
// as which organization we publish our artifact
organization := "io.github.christophknabe"
// The name of our artifact is derived from the project directory.

// Dependencies: Which artifacts does our project need:
// They are by default searched in Maven Central:
// https://mvnrepository.com/
libraryDependencies ++= Seq(
  // Java dependency:
  // organization      % artifact        % version  % scope
  "org.apache.commons" % "commons-lang3" % "3.12.0" % Compile,
  // Demo: Search this artifact in https://mvnrepository.com/

  // Scala dependency:
  // organization %% scalaVersionDependentArtifact % version % scope
  "org.scalatest" %% "scalatest" % "3.1.2" % Test,
  // Demo: Search this artifact in https://mvnrepository.com/
  // See the Scala version dependent artifact name scalatest-2.12-3.1.2.jar
  // in https://repo1.maven.org/maven2/org/scalatest/scalatest_2.12/3.1.2/

  "org.scalatestplus" %% "scalacheck-1-14" % "3.1.2.0" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)

// Demo: Navigate in IDEA: External Libraries: commons-lang3
// to method org.apache.commons.lang3.StringUtils.isBlank
// IDE downloads the source code of used libraries!

// Proceed to Test Drivers
