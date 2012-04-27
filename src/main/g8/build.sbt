import testgen.TestgenKeys._

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.2", "2.9.1", "2.9.0")

externalResolvers ~= (_.filter(_.name != "Scala-Tools Maven2 Repository"))

resolvers ++= Seq(
  "typesafe" at "http://repo.typesafe.com/typesafe/releases",
  "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"
)

libraryDependencies <++= (scalaVersion) { scalaVersion =>
  val _scalaVersion = "_" + (scalaVersion match {
    case "2.9.2" => "2.9.1"
    case version => version
  })
  val slf4s = "slf4s" + _scalaVersion
  Seq(
    "com.weiglewilczek.slf4s" % slf4s % "[1.0,)",
    "org.scalatest" %% "scalatest" % "[1.7,)" % "test"
  )
}

// http://ls.implicit.ly/

seq(lsSettings :_*)

// https://github.com/typesafehub/sbtscalariform

seq(scalariformSettings: _*)

// https://github.com/seratch/testgen-sbt

seq(testgenSettings: _*)

testgenEncoding in Compile := "UTF-8"

testgenTestTemplate in Compile := "scalatest.FlatSpec"

testgenScalaTestMatchers in Compile := "ShouldMatchers"

testgenLineBreak in Compile := "LF"


