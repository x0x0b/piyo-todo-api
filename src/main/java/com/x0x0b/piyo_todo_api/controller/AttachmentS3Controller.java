package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.dto.attachment.s3.AttachmentS3Response;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentS3Controller {

  List<AttachmentS3Response> getList(Long todoId);

  void upload(MultipartFile file, Long todoId);

}
