val scalaV = "2.12.15"
ThisBuild / scalaVersion := scalaV
ThisBuild / version := "1.0-SNAPSHOT"
ThisBuild / organization := "io.github.christophknabe"
ThisBuild / organizationName := "scala-intro"

val scalaTest = "org.scalatest" %% "scalatest" % "3.1.2" % Test
val junit = "com.novocode" % "junit-interface" % "0.11" % "test"


libraryDependencies ++= Seq(
  scalaTest,
  junit
)
