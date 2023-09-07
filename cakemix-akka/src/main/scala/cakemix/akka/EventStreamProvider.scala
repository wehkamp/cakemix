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
import akka.event.EventStream

/** Mixin trait that provides an Akka EventStream.
  */
trait EventStreamProvider {
  def eventStream: EventStream
}

/** Implementation of [[EventStreamProvider]] that uses the actor's context to provide an instance of EventStream.
  */
trait EventStreamProviderForActors extends EventStreamProvider { this: Actor =>
  implicit val eventStream: EventStream = context.system.eventStream
}
