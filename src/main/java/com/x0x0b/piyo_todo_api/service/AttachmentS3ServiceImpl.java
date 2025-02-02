package com.x0x0b.piyo_todo_api.service;

import com.x0x0b.piyo_todo_api.repository.AttachmentS3Repository;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentS3ServiceImpl implements AttachmentS3Service {

  private final AttachmentS3Repository attachmentS3Repository;

  public AttachmentS3ServiceImpl(AttachmentS3Repository attachmentS3Repository) {
    this.attachmentS3Repository = attachmentS3Repository;
  }

  public void upload(MultipartFile file, Long todoId) {
    String keyName = UUID.randomUUID().toString();

    attachmentS3Repository.uploadToS3(keyName, file);
    attachmentS3Repository.insert(keyName, file.getOriginalFilename(), todoId);
  }
}
