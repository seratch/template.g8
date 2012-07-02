import sbt._
import Keys._

object AppBuild extends Build {

  // root project

  lazy val rootProject = Project(id = "root", base = file("."), settings = rootSettings)

  lazy val rootSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    sbtPlugin := false,
    organization := "$organization$",
    name := "$name$",
    version := "$version$",
    scalaVersion := "$scala_version$",
    crossScalaVersions := Seq("$scala_version$"),
    externalResolvers ~= (_.filter(_.name != "Scala-Tools Maven2 Repository")),
    resolvers ++= Seq(
      "typesafe releases" at "http://repo.typesafe.com/typesafe/releases",
      "sonatype releases" at "http://oss.sonatype.org/content/repositories/releases/"
    ),
    libraryDependencies <++= (scalaVersion) { scalaVersion =>
    Seq(
      "org.scalatest" %% "scalatest" % "1.7.2" % "test"
    )},
    publishTo <<= version { (v: String) =>
      val nexus = "https://oss.sonatype.org/"
        if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
        else Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { x => false },
    pomExtra := (
      <url>https://github.com/$github_account$/$name$</url>
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:$github_account$/$name$.git</url>
        <connection>scm:git:git@github.com:$github_account$/$name$.git</connection>
      </scm>
      <developers>
        <developer>
          <id>$github_account$</id>
          <name>$github_account$</name>
          <url>https://github.com/$github_account$</url>
        </developer>
      </developers>
    ),
    scalacOptions ++= Seq("-deprecation", "-unchecked")
  )

  // lazy val subProject = Project(id = "sub", base = file("sub"))

}


