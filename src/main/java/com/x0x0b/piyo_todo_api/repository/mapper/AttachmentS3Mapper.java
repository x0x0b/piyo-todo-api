package com.x0x0b.piyo_todo_api.repository.mapper;

import com.x0x0b.piyo_todo_api.domain.AttachmentS3;
import java.util.List;

public interface AttachmentS3Mapper {

  List<AttachmentS3> getByTodoId(Long todoId);

  int insert(String bucketName, String keyName, String originalName, Long todoId);

}
