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

import akka.event.{ LoggingAdapter, NoLogging }

/**
 * Handy trait for expressing a need for an Akka LoggerAdapter.
 * This trait is usually implemented by mixing the standard Akka ActorLogging trait
 * into your top-level implementation actor (i.e. the Http entrypoint actor).
 */
trait LoggingProvider {
  def log: LoggingAdapter
}

/**
 * NoOp implementation of the LoggingProvider trait, mainly for use in tests.
 */
trait NoLoggingProvider extends LoggingProvider {
  def log: LoggingAdapter = NoLogging
}

/**
 * Handy for test debugging when you want to make absolutely sure your
 * log messages will not be filtered out by Akka and/or Logback.
 *
 * Only use when needed, tests should not normally produce logging and if you want
 * to produce proper logging, use a real (slf4j) adapter!
 */
trait StdOutLoggingProvider extends LoggingProvider {
  def log: LoggingAdapter = new LoggingAdapter {
    def isErrorEnabled = true
    def isWarningEnabled = true
    def isInfoEnabled = true
    def isDebugEnabled = true

    protected def notifyWarning(message: String): Unit = println(s"[warning] $message")
    protected def notifyInfo(message: String): Unit = println(s"[info] $message")
    protected def notifyDebug(message: String): Unit = println(s"[debug] $message")
    protected def notifyError(message: String): Unit = println(s"[error] $message")
    protected def notifyError(cause: Throwable, message: String): Unit = {
      println(s"[error]: $message")
      cause.printStackTrace()
    }
  }
}
