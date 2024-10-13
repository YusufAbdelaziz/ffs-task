package com.joe.abdelaziz.ffs_task.exception;

public class RecordNotFoundException extends RuntimeException {

  public RecordNotFoundException(String message) {
    super(message);
  }

  public RecordNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public RecordNotFoundException(String entityName, Long id) {
    super(String.format("%s with id %d not found", entityName, id));
  }
}