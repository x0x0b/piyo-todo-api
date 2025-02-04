package com.x0x0b.piyo_todo_api.dto.attachment.s3;

import com.x0x0b.piyo_todo_api.domain.AttachmentS3;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentS3Response extends AttachmentS3 {

  private String url;

  public AttachmentS3Response() {
    super();
  }

  public AttachmentS3Response(AttachmentS3 s3, String url) {
    super();
    this.setId(s3.getId());
    this.setTodoId(s3.getTodoId());
    this.setCreatedAt(s3.getCreatedAt());
    this.setUpdatedAt(s3.getUpdatedAt());
    this.setBucketName(s3.getBucketName());
    this.setKeyName(s3.getKeyName());
    this.setOriginalName(s3.getOriginalName());
    this.url = url;
  }
}
