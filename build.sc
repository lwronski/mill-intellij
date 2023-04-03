import $ivy.`com.lihaoyi::mill-contrib-bloop:$MILL_VERSION`
import $ivy.`de.tototec::de.tobiasroeser.mill.vcs.version_mill0.9:0.1.1`

import de.tobiasroeser.mill.vcs.version._
import mill._
import mill.scalalib._

import scala.concurrent.duration.{Duration, DurationInt}

val scalaVersion = Seq("2.12.17", "2.13.10", "3.2.2")

object dummy extends Module {
  // dummy projects to get scala steward updates for Ammonite and scalafmt, whose
  // versions are used in the fmt and repl commands, and ensure Ammonite is available
  // for all Scala versions we support.
  object amm extends Cross[Amm](scalaVersion: _*)
  class Amm(val crossScalaVersion: String) extends CrossScalaModule {
    def skipBloop = true
    def ivyDeps = Agg(
      ivy"com.lihaoyi:::ammonite:2.5.6-1-f8bff243"
    )
  }
}