package xebia.cakemix

import scala.concurrent.ExecutionContext
import akka.actor._

/**
 * Simple mixin trait for providing an ExecutionContext. Very useful in
 * any Scala code that uses or transforms Futures or the Akka ask pattern.
 */
trait ExecutionContextProvider {
  implicit def executionContext: ExecutionContext
}

/**
 * Implementation of ExecutionContextProvider that bridges with
 * [[xebia.cakemix.ActorRefFactoryProvider]] so anything that provides an
 * ActorRefFactory will get the dispatcher of the associated ActorSystem
 * provided as the ExecutionContext.
 */
trait ActorRefFactoryExecutionContextProvider extends ExecutionContextProvider with ActorRefFactoryProvider {
  implicit def executionContext = actorRefFactory.dispatcher
}

/**
 * Implementation of [[xebia.cakemix.ExecutionContextProvider]] for use in Actors.
 * It uses the Actor's context dispatcher as the ExecutionContext.
 */
trait ActorExecutionContextProvider extends ExecutionContextProvider { this: Actor ⇒
  implicit def executionContext = context.dispatcher
}

/**
 * Implementation of [[xebia.cakemix.ExecutionContextProvider]] that uses the
 * ExecutionContext provided by scala.concurrent.ExecutionContext.global.
 */
trait GlobalExecutionContextProvider {
  implicit def executionContext: ExecutionContext = scala.concurrent.ExecutionContext.global
}
