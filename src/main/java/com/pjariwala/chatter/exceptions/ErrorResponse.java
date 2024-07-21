package com.pjariwala.chatter.exceptions;

import lombok.Builder;
import lombok.Data;

/** */
@Data
@Builder
public class ErrorResponse {
  private String message;
  private String param;
  private int statusCode;
  private String type;
}
