package io.swagger.client;

import io.swagger.client.model.Error;
import io.swagger.client.model.GeneralNumber;

public class ApiException extends Exception {
  int code = 0;
  String message = null;

  public ApiException() {}

  public ApiException(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }
  
  public void setCode(int code) {
    this.code = code;
  }
  
  public String getMessage() {

    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }

  private Error error;
  private static ApiInvoker INSTANCE = new ApiInvoker();
  public Error getError() {
    try {
      error=(Error)ApiInvoker.deserialize(this.message, "", Error.class);
    } catch (ApiException e) {
      e.printStackTrace();
    }
    return error;
  }
}