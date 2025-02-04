package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.dto.attachment.web.AttachmentWebRequest;

public interface AttachmentWebController {

  void add(AttachmentWebRequest request, Long todoId);
}
