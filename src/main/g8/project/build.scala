import sbt._
import Keys._

object $name$Build extends Build {

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    sbtPlugin := false,
    organization := "$organization$",
    name := "$name$",
    version := "$version$",
    scalacOptions ++= Seq("-deprecation", "-unchecked")
  )

}


