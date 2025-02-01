package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.service.AttachmentS3Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/todo/{todoId}/attachment/s3")
public class AttachmentS3ControllerImpl implements AttachmentS3Controller {

  private final AttachmentS3Service attachmentS3Service;

  public AttachmentS3ControllerImpl(AttachmentS3Service attachmentS3Service) {
    this.attachmentS3Service = attachmentS3Service;
  }

  @Override
  @PostMapping("/upload")
  public void upload(@RequestBody MultipartFile file, @PathVariable("todoId") Long todoId) {
    attachmentS3Service.upload(file, todoId);
  }
}
