package com.x0x0b.piyo_todo_api.dto.attachment.web;

import java.util.List;
import lombok.Getter;

@Getter
public class AttachmentWebResponse {

  private List<WebResponse> webResponses;

  public AttachmentWebResponse(List<WebResponse> webResponses) {
    this.webResponses = webResponses;
  }

  @Getter
  public static class WebResponse {

    public WebResponse(String url) {
      this.url = url;
    }

    private String url;
  }
}
