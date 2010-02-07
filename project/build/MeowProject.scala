import sbt._

class MeowProject(info: ProjectInfo) extends DefaultProject(info) {
  override def crossScalaVersions = Set("2.7.3", "2.7.4", "2.7.5", "2.7.6", "2.7.7") 
  val stSnapshots = "Scala Tools Snapshots" at "http://www.scala-tools.org/repo-snapshots/"
  val specs = "org.scala-tools.testing" % "specs" % "1.6.2-SNAPSHOT" % "test"
  
  override def managedStyle = ManagedStyle.Maven
  lazy val publishTo = Resolver.file("lessis repo", new java.io.File("/var/www/repo"))
}