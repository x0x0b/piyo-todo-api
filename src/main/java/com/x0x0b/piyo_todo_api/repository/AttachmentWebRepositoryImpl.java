package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import com.x0x0b.piyo_todo_api.repository.mapper.AttachmentWebMapper;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AttachmentWebRepositoryImpl implements AttachmentWebRepository {

  private final AttachmentWebMapper attachmentWebMapper;

  public AttachmentWebRepositoryImpl(AttachmentWebMapper attachmentWebMapper) {
    this.attachmentWebMapper = attachmentWebMapper;
  }

  @Override
  public List<AttachmentWeb> getList(Long todoId) {
    return attachmentWebMapper.getByTodoId(todoId);
  }

  @Override
  public void insert(Long todoId, String url, String name) {
    attachmentWebMapper.insert(todoId, url, name);
  }

}
