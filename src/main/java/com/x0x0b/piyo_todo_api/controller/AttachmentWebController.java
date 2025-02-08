package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;

public interface AttachmentWebController {

  void add(AttachmentWeb request, Long todoId);
}
