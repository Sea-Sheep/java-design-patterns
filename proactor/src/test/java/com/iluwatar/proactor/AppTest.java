package com.iluwatar.proactor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class AppTest {
  @Test
  void shouldExecuteApplicationWithoutException() {
    assertDoesNotThrow(() -> App.main(null));
  }
}
