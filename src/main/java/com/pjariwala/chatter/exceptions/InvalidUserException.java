package com.pjariwala.chatter.exceptions;

public class InvalidUserException extends BaseException {
  public InvalidUserException(String message) {
    super(message);
  }

  public InvalidUserException(String message, String status) {
    super(message, status);
  }
}
