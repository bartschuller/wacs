import sbt._

class WacsProject(info: ProjectInfo) extends DefaultWebProject(info) with IdeaPlugin {
  override def scanDirectories = Nil
  // val mavenLocal = "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
  val jbossReleases = "JBoss Releases" at "http://repository.jboss.org/maven2/"

  val jetty7 = "org.eclipse.jetty" % "jetty-webapp" % "7.0.1.v20091125" % "test"  // jetty is only need for testing
  val resteasy = "org.jboss.resteasy" % "resteasy-jaxrs" % "1.2.1.GA" % "compile"

  //lazy val subProject = project("subproject", "subproject", new DefaultProject(_) with IdeaPlugin)
   // ...
}
