package com.x0x0b.piyo_todo_api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AttachmentS3 extends AttachmentBase implements Attachment {

  private String bucketName;
  private String keyName;

  @Override
  public String getUrl() {
    // TODO: Implement this method
    return "";
  }

  @Override
  public void setUrl(String url) {
    // TODO: Implement this method
  }
}
