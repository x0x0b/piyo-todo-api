package com.x0x0b.piyo_todo_api.domain;

import com.x0x0b.piyo_todo_api.enums.AttachmentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AttachmentS3 extends AttachmentBase implements Attachment {

  private String bucketName;
  private String keyName;
  private String originalName;

  public AttachmentS3() {
    super(AttachmentType.S3);
  }

  @Override
  public String getUrl() {
    // TODO: Implement this method
    return "";
  }
}
