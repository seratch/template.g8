import sbt._
import Keys._

object MyBuild extends Build {

  lazy val root = Project("root", file("."), settings = mainSettings)

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    sbtPlugin := false,
    organization := "$organization$",
    name := "$name$",
    version := "$version$",
    scalacOptions ++= Seq("-deprecation", "-unchecked")
  )

}


