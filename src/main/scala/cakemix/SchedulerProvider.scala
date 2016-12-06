package cakemix

import akka.actor._

/**
 * Mixin trait that provides an Akka Scheduler.
 */
trait SchedulerProvider {
  implicit def scheduler: Scheduler
}

/**
 * Implementation of [[cakemix.SchedulerProvider]] that uses the
 * actor's context to provide an instance of Scheduler.
 */
trait SchedulerProviderForActors { this: Actor ⇒
  def scheduler: Scheduler = context.system.scheduler
}
