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
