import sbt._

class WacsProject(info: ProjectInfo) extends DefaultWebProject(info) with IdeaPlugin {
  // for JRebel, so changes to classes don't trigger a redeploy
  // when using ~ prepare-webapp
  override def scanDirectories = Nil

  // val mavenLocal = "Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
  val jbossReleases = "JBoss Releases" at "http://repository.jboss.org/maven2/"

  val jetty7 = "org.eclipse.jetty" % "jetty-webapp" % "7.0.1.v20091125" % "test"  // jetty is only need for testing
  val resteasy = "org.jboss.resteasy" % "resteasy-jaxrs" % "1.2.1.GA" % "compile"
  val servlet = "javax.servlet" % "servlet-api" % "2.5" % "provided"

  //lazy val subProject = project("subproject", "subproject", new DefaultProject(_) with IdeaPlugin)
  // ...

  val viewSourcePath = mainSourcePath / "views"
  val viewSources = (viewSourcePath ##) ** ("*.*" - "*.scala")
  val viewScalaPath = outputPath / "view-src"
  val viewScalaSources = viewScalaPath ** viewSources.getPaths.map {"""\.(.*?)$""".r.replaceFirstIn(_, ".scala")}
  
  lazy val transformViews = transformViewsAction
  def transformViewsAction = transformViewsTask describedAs("compiles view XML to Scala")
  def transformViewsTask = fileTask(viewScalaPath from viewSources) {
    log.info("transforming views.")
    FileUtilities.createDirectory(viewScalaPath, log)
    None
  }

  override def compileAction = super.compileAction dependsOn(transformViews)
}
