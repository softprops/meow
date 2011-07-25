organization := "me.lessis"

name := "meow"

version := "0.1.1-SNAPSHOT"

libraryDependencies += "org.scala-tools.testing" % "specs" % "1.6.2.1" % "test"

crossScalaVersions ++= Seq("2.8.0","2.8.1","2.9.0")

publishTo :=  Some(Resolver.file("lessis repo", new java.io.File("/var/www/repo")))
