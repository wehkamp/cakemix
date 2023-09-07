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

import akka.actor.Actor
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

/** Simple mixin trait for providing an ExecutionContext. Very useful in any Scala code that uses or transforms Futures
  * or the Akka ask pattern.
  */
trait ExecutionContextProvider {
  implicit def executionContext: ExecutionContext
}

/** Implementation of ExecutionContextProvider that bridges with [[ActorRefFactoryProvider]] so anything that provides
  * an ActorRefFactory will get the dispatcher of the associated ActorSystem provided as the ExecutionContext.
  */
trait ActorRefFactoryExecutionContextProvider extends ExecutionContextProvider with ActorRefFactoryProvider {
  implicit def executionContext: ExecutionContextExecutor = actorRefFactory.dispatcher
}

/** Implementation of [[ExecutionContextProvider]] for use in Actors. It uses the Actor's context dispatcher as the
  * ExecutionContext.
  */
trait ActorExecutionContextProvider extends ExecutionContextProvider { this: Actor =>
  implicit def executionContext: ExecutionContextExecutor = context.dispatcher
}

/** Implementation of [[ExecutionContextProvider]] that uses the ExecutionContext provided by
  * scala.concurrent.ExecutionContext.global.
  */
trait GlobalExecutionContextProvider extends ExecutionContextProvider {
  implicit def executionContext: ExecutionContext = scala.concurrent.ExecutionContext.global
}
