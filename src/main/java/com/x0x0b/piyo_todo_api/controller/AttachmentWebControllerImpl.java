package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import com.x0x0b.piyo_todo_api.dto.attachment.web.AttachWebRequest;
import com.x0x0b.piyo_todo_api.service.AttachmentWebService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo/{todoId}/attachment/web")
public class AttachmentWebControllerImpl implements AttachmentWebController {

  private final AttachmentWebService attachmentWebService;

  public AttachmentWebControllerImpl(AttachmentWebService attachmentWebService) {
    this.attachmentWebService = attachmentWebService;
  }

  @Override
  @PostMapping("/add")
  public void add(@RequestBody AttachWebRequest request, @PathVariable("todoId") Long todoId) {
    AttachmentWeb attachmentWeb = new AttachmentWeb();
    attachmentWeb.setTodoId(todoId);
    attachmentWeb.setUrl(request.getUrl());
    attachmentWebService.add(attachmentWeb);
  }
}
