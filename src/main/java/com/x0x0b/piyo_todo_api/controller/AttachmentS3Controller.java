package com.x0x0b.piyo_todo_api.controller;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentS3Controller {

  void upload(MultipartFile file, Long todoId);
}
