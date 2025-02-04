package com.x0x0b.piyo_todo_api.domain;

import com.x0x0b.piyo_todo_api.enums.AttachmentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@ToString
public class AttachmentS3 extends AttachmentBase implements Attachment {

  private String bucketName;
  private String keyName;
  private String originalName;

  @Value("${piyo-todo.aws.s3.expiration-minutes:10}")
  private int expirationMinutes;

  public AttachmentS3() {
    super(AttachmentType.S3);
  }
}
