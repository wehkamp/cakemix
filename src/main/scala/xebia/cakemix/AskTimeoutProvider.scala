package xebia.cakemix

import scala.concurrent.duration._

import com.typesafe.config.Config
import net.ceedubs.ficus.Ficus._

import akka.actor._
import akka.util._

/**
 * Provides an implicit instance of Timeout for when you use the Akka
 * ask pattern
 */
trait AskTimeoutProvider {
  implicit def askTimeout: Timeout
}

object AskTimeoutProvider {
  private val AskTimeoutConfigKey = "xebia.cakemix.ask-timeout"

  def fromConfig(config: Config, key: String = AskTimeoutConfigKey): Timeout = {
    Timeout(config.as[FiniteDuration](key))
  }
}

trait ActorAskTimeoutProvider extends AskTimeoutProvider { this: Actor ⇒
  implicit def askTimeout = AskTimeoutProvider.fromConfig(context.system.settings.config)
}

/** For all those tests where you just need a simple askTimeout provider... */
trait TestOnlyHardcodedAskTimeoutProvider extends AskTimeoutProvider {
  implicit def askTimeout = Timeout(1 second)
}
