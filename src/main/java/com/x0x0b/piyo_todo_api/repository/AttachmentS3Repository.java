package com.x0x0b.piyo_todo_api.repository;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentS3Repository {

  void insert(String keyName, String originalFilename, Long todoId);

  void uploadToS3(String keyName, MultipartFile file);
}
