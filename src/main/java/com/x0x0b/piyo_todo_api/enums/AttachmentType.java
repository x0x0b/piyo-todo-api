package com.x0x0b.piyo_todo_api.enums;

public enum AttachmentType {
  S3(0),
  WEB(1);

  private final int code;

  AttachmentType(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
