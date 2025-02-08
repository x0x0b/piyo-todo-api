package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.domain.Attachment;
import com.x0x0b.piyo_todo_api.domain.Todo;
import com.x0x0b.piyo_todo_api.repository.mapper.TodoMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

  private final TodoMapper todoMapper;
  private final AttachmentS3Repository s3Repository;
  private final AttachmentWebRepository webRepository;

  public TodoRepositoryImpl(TodoMapper todoMapper, AttachmentS3Repository s3Repository,
      AttachmentWebRepository webRepository) {
    this.todoMapper = todoMapper;
    this.s3Repository = s3Repository;
    this.webRepository = webRepository;
  }

  @Override
  public List<Todo> getList() {
    List<Todo> todos = todoMapper.getList();
    for (Todo todo : todos) {
      todo.setAttachments(getAttachments(todo.getId()));
    }
    return todos;
  }

  @Override
  public Todo get(Long id) {
    Todo todo = todoMapper.get(id);
    todo.setAttachments(getAttachments(id));
    return todo;
  }

  private List<Attachment> getAttachments(Long todoId) {
    List<Attachment> attachments = new ArrayList<>();
    attachments.addAll(s3Repository.getList(todoId));
    attachments.addAll(webRepository.getList(todoId));
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
