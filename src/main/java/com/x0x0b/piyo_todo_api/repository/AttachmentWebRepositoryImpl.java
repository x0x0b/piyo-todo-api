package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.repository.mapper.AttachmentWebMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AttachmentWebRepositoryImpl implements AttachmentWebRepository {

  private final AttachmentWebMapper attachmentWebMapper;

  public AttachmentWebRepositoryImpl(AttachmentWebMapper attachmentWebMapper) {
    this.attachmentWebMapper = attachmentWebMapper;
  }

  @Override
  public void insert(Long todoId, String url) {
    attachmentWebMapper.insert(todoId, url);
  }

}
