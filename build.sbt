import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.apache.uima" % "uimafit-core" % "2.3.0",
    libraryDependencies += "org.apache.uima" % "uimaj-tools" % "2.10.1"
  )
