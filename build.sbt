name := """flyway-3362"""
organization := "hertg"
version := "0.1.0"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean, DockerPlugin)

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  guice,
  "mysql" % "mysql-connector-java" % "8.0.28",
  "org.flywaydb" %% "flyway-play" % "7.19.0",
)

Universal / javaOptions ++= Seq(
  "-Dpidfile.path=/dev/null",
  "-Dconfig.resource=prod.conf",
  "-Dlogback.configurationFile=logback.prod.xml",
)