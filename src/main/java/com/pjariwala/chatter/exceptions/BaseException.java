package com.pjariwala.chatter.exceptions;

import lombok.Getter;

public class BaseException extends RuntimeException {
  @Getter private String errorCode;
  @Getter private String param;

  public BaseException() {
    super();
  }

  public BaseException(Exception ex) {
    super(ex);
  }

  public BaseException(String msg) {
    super(msg);
  }

  public BaseException(String msg, String errCode) {
    super(msg);
    errorCode = errCode;
  }

  public BaseException(String msg, String errCode, String parameter) {
    super(msg);
    errorCode = errCode;
    param = parameter;
  }
}
