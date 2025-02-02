package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.dto.attachment.web.AttachWebRequest;

public interface AttachmentWebController {

  void add(AttachWebRequest request, Long todoId);
}
