package com.iluwatar.proactor;

import java.io.NotActiveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines a service that can be executed asynchronously.
 */
public class AsynchronousOperation {

  /**
   *  Logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(AsynchronousOperation.class);

  /**
   * Execute the task.
   *
   * @param operation task to do
   * @return the handler
   */
  public Handle execute(String operation) throws NotActiveException, InterruptedException {
    if ("task1".equals(operation)) {
      LOGGER.info("task1 started!");
      Thread.sleep(500);
      LOGGER.info("task1 finished!");
      return new Handle("short");
    } else if ("task2".equals(operation)) {
      LOGGER.info("task2 started!");
      Thread.sleep(600);
      LOGGER.info("task2 finished!");
      return new Handle("long");
    }
    throw new NotActiveException("error");
  }
}
