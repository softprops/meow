organization := "me.lessis"

name := "meow"

version := "0.1.1"

crossScalaVersions ++= Seq(
  "2.8.0","2.8.1","2.9.0", "2.9.0-1", "2.9.1.RC1", "2.9.1", "2.9.2")

publishTo := Some(Opts.resolver.sonatypeStaging)

publishMavenStyle := true

publishArtifact in Test := false

version := "0.1.0"

licenses <<= (version)(v =>
      Seq("MIT" ->
          url("https://github.com/softprops/meow/blob/%s/LICENSE" format v)))

homepage := some(url("https://github.com/softprops/meow/#readme"))

pomExtra := (
  <scm>
    <url>git@github.com:softprops/meow.git</url>
    <connection>scm:git:git@github.com:softprops/meow.git</connection>
  </scm>
  <developers>
    <developer>
      <id>softprops</id>
      <name>Doug Tangren</name>
      <url>https://github.com/softprops</url>
    </developer>
  </developers>)

libraryDependencies <+=  (scalaVersion)(sv =>
    sv.split('.').toList match {
      case "2" :: "8" :: _ =>
        "org.scala-tools.testing" % "specs_2.8.1" % "1.6.8" % "test"
      case "2" :: "9" :: "1" :: _ =>
        "org.scala-tools.testing" % "specs_2.9.0-1" % "1.6.8" % "test"
      case "2" :: "9" :: _ =>
        "org.scala-tools.testing" % "specs_2.9.1" % "1.6.9" % "test"
      case _ => error("specs not supported for scala version %s" format sv)
    }
)
