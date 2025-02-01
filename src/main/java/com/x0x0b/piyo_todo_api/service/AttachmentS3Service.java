package com.x0x0b.piyo_todo_api.service;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentS3Service {

  void upload(MultipartFile file, Long todoId);

}
