package cakemix

import akka.actor._
import akka.event.EventStream

/**
 * Mixin trait that provides an Akka EventStream.
 */
trait EventStreamProvider {
  def eventStream: EventStream
}

/**
 * Implementation of [[cakemix.EventStreamProvider]] that uses the
 * actor's context to provide an instance of EventStream.
 */
trait EventStreamProviderForActors extends EventStreamProvider { this: Actor ⇒
  implicit val eventStream = context.system.eventStream
}
