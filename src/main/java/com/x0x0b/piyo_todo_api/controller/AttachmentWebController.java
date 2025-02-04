package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.dto.attachment.web.AttachmentWebRequest;
import com.x0x0b.piyo_todo_api.dto.attachment.web.AttachmentWebResponse;

public interface AttachmentWebController {

  AttachmentWebResponse getList(Long todoId);

  void add(AttachmentWebRequest request, Long todoId);
}
