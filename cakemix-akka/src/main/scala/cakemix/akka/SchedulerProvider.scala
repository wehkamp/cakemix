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

import akka.actor.{Actor, Scheduler}

/** Mixin trait that provides an Akka Scheduler.
  */
trait SchedulerProvider {
  implicit def scheduler: Scheduler
}

/** Implementation of [[SchedulerProvider]] that uses the actor's context to provide an instance of Scheduler.
  */
trait SchedulerProviderForActors { this: Actor =>
  def scheduler: Scheduler = context.system.scheduler
}
