package cakemix

import akka.actor._

trait ActorLifecycleLogging extends Actor
    with ActorLogging {

  override def preStart: Unit = {
    log.info(s"Starting. Path: ${self.path}.")
    super.preStart()
  }

  override def postStop: Unit = {
    log.info(s"Stopping. Path: ${self.path}.")
    super.postStop()
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    log.info(s"Actor will be restarted. Path: ${self.path}. Reason: ${reason}. Message: ${message}.")
    super.preRestart(reason, message)
  }

  override def postRestart(reason: Throwable): Unit = {
    log.info(s"Actor was restarted. Path: ${self.path}. Reason: ${reason}.")
    super.postRestart(reason)
  }
}
