import testgenerator.SbtKeys._

scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.2", "2.9.1", "2.9.0")

externalResolvers ~= (_.filter(_.name != "Scala-Tools Maven2 Repository"))

resolvers ++= Seq(
  "typesafe" at "http://repo.typesafe.com/typesafe/releases",
  "sonatype" at "http://oss.sonatype.org/content/repositories/releases/",
  "sbt-idea" at "http://mpeltonen.github.com/maven/"
)

libraryDependencies <++= (scalaVersion) { scalaVersion =>
  Seq(
    "org.scalatest" %% "scalatest" % "1.7.2" % "test"
  )
}

// http://ls.implicit.ly/

seq(lsSettings :_*)

// https://github.com/typesafehub/sbtscalariform

seq(scalariformSettings: _*)

// https://github.com/seratch/testgenerator

seq(testgeneratorSettings: _*)

testgeneratorEncoding in Compile := "UTF-8"

testgeneratorTestTemplate in Compile := "scalatest.FlatSpec"

testgeneratorScalaTestMatchers in Compile := "ShouldMatchers"

testgeneratorLineBreak in Compile := "LF"

