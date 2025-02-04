package com.x0x0b.piyo_todo_api.service;

import com.x0x0b.piyo_todo_api.domain.AttachmentS3;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentS3Service {

  List<AttachmentS3> getList(Long todoId);

  void upload(MultipartFile file, Long todoId);

  String getPresignedUrl(String keyName);
}
