package xebia.cakemix

import akka.actor._

/**
 * Mixin trait that provides an Akka Scheduler.
 */
trait SchedulerProvider {
  def scheduler: Scheduler
}

/**
 * Implementation of [[xebia.cakemix.SchedulerProvider]] that uses the
 * actor's context to provide an instance of Scheduler.
 */
trait SchedulerProviderForActors { this: Actor ⇒
  def scheduler: Scheduler = context.system.scheduler
}
