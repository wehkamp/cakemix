package xebia.cakemix

import akka.actor._

/**
 * Mixin trait that defines methods for looking up and creating child actors.
 *
 * Example:
 * Your application has a Spray endpoint, which is usually a subclass of
 * HttpServiceActor or an Actor that implements HttpService. That Spray endpoint
 * actor can be built up using the cake pattern, combining many mixin traits that
 * provide parts of the API and their implementations (i.e. child actors).
 * Those Mixin traits can then use this trait to abstract away the creation of
 * child actors until they all gets mixed in together with an implementation
 * like [[xebia.cakemix.ActorCreationSupportForActors]].
 */
trait ActorCreationSupport {
  def createChild(props: Props, name: String): ActorRef
  def getChild(name: String): Option[ActorRef]
  def getOrCreateChild(props: Props, name: String): ActorRef = getChild(name).getOrElse(createChild(props, name))
}

/**
 * The default implementation of the [[xebia.cakemix.ActorCreationSupport]] that
 * can be mixed into Actors.
 */
trait ActorCreationSupportForActors extends ActorCreationSupport { this: Actor ⇒
  def createChild(props: Props, name: String): ActorRef = context.actorOf(props, name)
  def getChild(name: String) = context.child(name)
}
