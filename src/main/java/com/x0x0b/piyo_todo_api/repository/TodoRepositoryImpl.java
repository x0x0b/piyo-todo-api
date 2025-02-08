package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.domain.Attachment;
import com.x0x0b.piyo_todo_api.domain.Todo;
import com.x0x0b.piyo_todo_api.repository.mapper.AttachmentS3Mapper;
import com.x0x0b.piyo_todo_api.repository.mapper.AttachmentWebMapper;
import com.x0x0b.piyo_todo_api.repository.mapper.TodoMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

  private final TodoMapper todoMapper;
  private final AttachmentS3Mapper attachmentS3Mapper;
  private final AttachmentWebMapper attachmentWebMapper;

  public TodoRepositoryImpl(TodoMapper todoMapper, AttachmentS3Mapper attachmentS3Mapper,
      AttachmentWebMapper attachmentWebMapper) {
    this.todoMapper = todoMapper;
    this.attachmentS3Mapper = attachmentS3Mapper;
    this.attachmentWebMapper = attachmentWebMapper;
  }

  @Override
  public List<Todo> getList() {
    return todoMapper.getList();
  }

  @Override
  public Todo get(Long id) {
    Todo todo = todoMapper.get(id);
    todo.setAttachments(getAttachments(id));
    return todo;
  }

  private List<Attachment> getAttachments(Long todoId) {
    List<Attachment> attachments = new ArrayList<>();
    attachments.addAll(attachmentS3Mapper.getByTodoId(todoId));
    attachments.addAll(attachmentWebMapper.getByTodoId(todoId));
    return attachments;
  }

  @Override
  public int add(Todo todo) {
    return todoMapper.add(todo);
  }

  @Override
  public int set(Todo todo) {
    return todoMapper.set(todo);
  }
}
