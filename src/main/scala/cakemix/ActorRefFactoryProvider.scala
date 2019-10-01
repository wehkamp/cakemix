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

package cakemix

import akka.actor.{ Actor, ActorContext, ActorRefFactory, ExtendedActorSystem }

/**
 * Mixin trait for providing an implementation of the Akka ActorRefFactory trait.
 */
trait ActorRefFactoryProvider {
  implicit def actorRefFactory: ActorRefFactory

  def actorSystem(implicit refFactory: ActorRefFactory): ExtendedActorSystem = {
    refFactory match {
      case x: ActorContext        => actorSystem(x.system)
      case x: ExtendedActorSystem => x
      case _                      => throw new IllegalArgumentException("Unsupported ActorRefFactory implementation: " + refFactory)
    }
  }
}

/**
 * Implementation of ActorRefFactoryProvider for mixing into Actors.
 */
trait ActorRefFactoryProviderForActors extends ActorRefFactoryProvider { this: Actor =>
  def actorRefFactory: ActorRefFactory = context
}
