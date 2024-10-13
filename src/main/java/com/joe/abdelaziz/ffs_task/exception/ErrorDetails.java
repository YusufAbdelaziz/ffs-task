package com.joe.abdelaziz.ffs_task.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDetails {
  private int status;
  private String message;
  private String details;

}
