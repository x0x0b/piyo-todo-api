package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.domain.AttachmentS3;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentS3Repository {

  List<AttachmentS3> getList(Long todoId);

  int insert(String keyName, String originalFilename, Long todoId);

  void uploadToS3(String keyName, MultipartFile file);

}
