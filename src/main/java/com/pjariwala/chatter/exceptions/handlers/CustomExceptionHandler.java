package com.pjariwala.chatter.exceptions.handlers;

import com.pjariwala.chatter.exceptions.BaseException;
import com.pjariwala.chatter.exceptions.ErrorResponse;
import com.pjariwala.chatter.exceptions.InvalidUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/** Custom exceptions. */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({InvalidUserException.class})
  public ResponseEntity<ErrorResponse> notFoundExceptionHandler(BaseException ex, WebRequest wr) {
    return getExceptionResponse(ex, wr, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  private ResponseEntity<com.pjariwala.chatter.exceptions.ErrorResponse> getExceptionResponse(
      BaseException ex, WebRequest wr, HttpStatus status) {
    log.error("Status={} Exception={}", status, ex.getMessage(), ex);

    ResponseEntity<ErrorResponse> responseEntityObject =
        new ResponseEntity<>(
            ErrorResponse.builder()
                .message(ex.getMessage())
                .param(ex.getParam())
                .statusCode(status.value())
                .type(status.name())
                .build(),
            status);

    log.info("Exception response Object : {}", responseEntityObject);

    return responseEntityObject;
  }
}
