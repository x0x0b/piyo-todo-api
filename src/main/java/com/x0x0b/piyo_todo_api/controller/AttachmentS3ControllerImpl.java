package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.domain.AttachmentS3;
import com.x0x0b.piyo_todo_api.dto.attachment.s3.AttachmentS3Response;
import com.x0x0b.piyo_todo_api.service.AttachmentS3Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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
  @GetMapping("/getList")
  public List<AttachmentS3Response> getList(@PathVariable("todoId") Long todoId) {
    List<AttachmentS3> attachments = attachmentS3Service.getList(todoId);
    List<AttachmentS3Response> s3Responses = new ArrayList<>();
    for (AttachmentS3 attachment : attachments) {
      AttachmentS3Response s3Response = new AttachmentS3Response(
          attachment,
          attachmentS3Service.getPresignedUrl(attachment.getKeyName())
      );
      s3Responses.add(s3Response);
    }
    return s3Responses;
  }

  @Override
  @PostMapping("/upload")
  public void upload(@RequestBody MultipartFile file, @PathVariable("todoId") Long todoId) {
    attachmentS3Service.upload(file, todoId);
  }
}
