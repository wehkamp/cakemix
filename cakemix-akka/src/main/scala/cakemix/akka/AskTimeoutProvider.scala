/*
 * Cakemix
 *
 * Copyright Xebia BV and Wehkamp BV
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package cakemix.akka

import akka.actor.{Actor, ActorSystem}
import akka.util.Timeout
import scala.concurrent.duration._

import com.typesafe.config.Config

/** Provides an implicit instance of Timeout for when you use the Akka ask pattern
  */
trait AskTimeoutProvider {
  implicit def askTimeout: Timeout
}

object AskTimeoutProvider {
  private val AskTimeoutConfigKey = "cakemix.ask-timeout"

  def fromConfig(config: Config, key: String = AskTimeoutConfigKey): Timeout = {
    Timeout(Duration.fromNanos(config.getDuration(key).toNanos))
  }
}

trait ActorAskTimeoutProvider extends AskTimeoutProvider { this: Actor =>
  implicit def askTimeout: Timeout = AskTimeoutProvider.fromConfig(context.system.settings.config)
}

trait ActorSystemAskTimeoutProvider extends AskTimeoutProvider {
  def system: ActorSystem
  implicit def askTimeout: Timeout = AskTimeoutProvider.fromConfig(system.settings.config)
}

/** For all those tests where you just need a simple askTimeout provider... */
trait TestOnlyHardcodedAskTimeoutProvider extends AskTimeoutProvider {
  implicit def askTimeout: Timeout = Timeout(1.second)
}
