organization := "me.lessis"

name := "meow"

version := "0.1.1"

crossScalaVersions ++= Seq("2.10.0")

scalaVersion := "2.10.0"

scalacOptions := Seq("-feature")

publishTo := Some(Opts.resolver.sonatypeStaging)

publishMavenStyle := true

publishArtifact in Test := false

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
