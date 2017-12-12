import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.usfinformatics.hs619",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "uima-annotator",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.apache.uima" % "uimafit-core" % "2.3.0",
    libraryDependencies += "org.apache.uima" % "uimaj-tools" % "2.10.1",
    libraryDependencies += "org.apache.uima" % "uimaj-core" % "2.10.1",
    libraryDependencies += "org.apache.ctakes" % "ctakes-core" % "4.0.0",
    libraryDependencies += "org.apache.ctakes" % "ctakes-chunker" % "4.0.0",
    libraryDependencies += "org.apache.ctakes" % "ctakes-dictionary-lookup" % "4.0.0",
    libraryDependencies += "org.apache.ctakes" % "ctakes-dictionary-lookup-fast" % "4.0.0",
    libraryDependencies += "org.apache.ctakes" % "ctakes-drug-ner" % "4.0.0",
    libraryDependencies += "org.apache.ctakes" % "ctakes-ne-contexts" % "4.0.0",
    libraryDependencies += "org.apache.ctakes" % "ctakes-clinical-pipeline" % "4.0.0",
    libraryDependencies += "org.apache.ctakes" % "ctakes-context-tokenizer" % "4.0.0"

  )
