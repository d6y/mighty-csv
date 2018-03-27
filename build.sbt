name := "mighty-csv"

version := "0.2"

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.2", "2.10.4")

retrieveManaged := true

publishMavenStyle := true

lazy val nexus = "https://oss.sonatype.org/"
publishTo := (version.value.trim.endsWith("SNAPSHOT") match {
  case true => Some("snapshots" at nexus + "content/repositories/snapshots") 
  case false => Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }
)

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/t-pleasure/mighty-csv</url>
  <licenses>
    <license>
      <name>Apache 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:t-pleasure/mighty-csv.git</url>
    <connection>scm:git:git@github.com:t-pleasure/mighty-csv.git</connection>
  </scm>
  <developers>
    <developer>
      <id>t-pleasure</id>
      <name>Tony Tran</name>
      <url>http://github.com/t-pleasure</url>
    </developer>
  </developers>)


libraryDependencies += "net.sf.opencsv"%"opencsv"%"2.3"

libraryDependencies += "junit"%"junit"%"4.8.2"%"test"

libraryDependencies += "org.scalatest"%%"scalatest"%"3.0.5"%"test"
 
scalacOptions ++= Seq(
  "-feature",
  "-unchecked",
  "-deprecation",
  "-language:implicitConversions",
  "-language:postfixOps"
)
