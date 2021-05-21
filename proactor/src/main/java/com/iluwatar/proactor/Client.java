package com.iluwatar.proactor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client side.
 */
public class Client {

  /**
   *  Logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  /**
   * Normally use internet to communicate between server and client.
   */
  public void run(AsynchronousOperationProcessor op) throws Exception {
    final ConcreteCompletionHandler c1 = new ConcreteCompletionHandler("short");
    ExecutorService executor = Executors.newFixedThreadPool(3);
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      try {
        return op.register("task1", c1);
      } catch (Exception e) {
        LOGGER.info("context", e);
      }
      return null;
    }, executor);

    future.thenAccept(System.out::println);
    Thread.sleep(750);
    final ConcreteCompletionHandler c2 = new ConcreteCompletionHandler("long");

    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
      try {
        return op.register("task2", c2);
      } catch (Exception e) {
        LOGGER.info("context", e);
      }
      return null;
    }, executor);
    future1.thenAccept(System.out::println);
    executor.shutdown();
  }
}
