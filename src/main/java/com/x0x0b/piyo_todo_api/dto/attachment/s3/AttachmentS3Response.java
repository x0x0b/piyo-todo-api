package com.x0x0b.piyo_todo_api.dto.attachment.s3;

import java.util.List;
import lombok.Getter;

@Getter
public class AttachmentS3Response {

  public AttachmentS3Response(List<S3Response> s3Responses) {
    this.s3Responses = s3Responses;
  }

  private List<S3Response> s3Responses;

  @Getter
  public static class S3Response {

    public S3Response(String originalFilename, String url) {
      this.originalFilename = originalFilename;
      this.url = url;
    }

    private String originalFilename;
    private String url;
  }
}
