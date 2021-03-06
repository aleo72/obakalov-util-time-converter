name := """obakalov-util-time-converter"""

version := "0.1.0"

scalaVersion := "2.12.2"

lazy val obakalovUtilTimeConverter = project in file(".")

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

libraryDependencies += "joda-time" % "joda-time" % "2.9.2"


// sbt clean coverage test coverageReport
parallelExecution in Test := false

//coverageEnabled := true
//
//coverageMinimum := 100
//
//coverageFailOnMinimum := true
