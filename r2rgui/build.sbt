////////////////////////////////////////////////
// General Settings
////////////////////////////////////////////////

name := "r2r"

version := "1.0.0-SNAPSHOT"

play.Project.playScalaSettings


////////////////////////////////////////////////
// War Packaging
////////////////////////////////////////////////

com.github.play2war.plugin.Play2WarPlugin.play2WarSettings

com.github.play2war.plugin.Play2WarKeys.servletVersion := "3.0"






