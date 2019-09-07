name := "scalaswingdemo"

version := "0.1"

scalaVersion := "2.13.0"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  "JBoss repository" at "https://repository.jboss.org/nexus/content/repositories/",
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"
)

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.1.1"
libraryDependencies += "org.postgresql" % "postgresql" % "42.1.1"
libraryDependencies += "org.playframework.anorm" %% "anorm" % "2.6.4"
libraryDependencies += "com.miglayout" % "miglayout-swing" % "5.0"
libraryDependencies += "de.sciss" % "syntaxpane" % "1.2.0"

