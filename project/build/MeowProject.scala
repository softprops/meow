import sbt._

class MeowProject(info: ProjectInfo) extends DefaultProject(info) {
  val stSnapshots = "Scala Tools Snapshots" at "http://www.scala-tools.org/repo-snapshots/"
  val specs = "org.scala-tools.testing" % "specs" % "1.6.2.1-SNAPSHOT" % "test"
  
  override def managedStyle = ManagedStyle.Maven
  lazy val publishTo = Resolver.file("lessis repo", new java.io.File("/var/www/repo"))
}