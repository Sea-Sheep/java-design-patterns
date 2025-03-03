package com.iluwatar.proactor;


/**
 * Proactor is a software design pattern for event handling in which
 * long running activities are running in an asynchronous part.
 *
 * <p>This pattern simplifies asynchronous application development
 * by integrating the demultiplexing of completion events and the
 * dispatching of their corresponding event handlers.
 */
public class App {
  /**
   * Execute the pattern. Create a client to run the function defined in function run.
   *
   * @param args system input
   */
  public static void main(String[] args) throws Exception {
    // Create an operationProcessor as a global object,
    // and make client running using the operationProcessor.
    var operationProcessor = new AsynchronousOperationProcessor();
    var client = new Client();
    client.run(operationProcessor);
  }
}
