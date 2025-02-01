package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.domain.Todo;
import com.x0x0b.piyo_todo_api.repository.mapper.TodoMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

  private final TodoMapper todoMapper;

  public TodoRepositoryImpl(TodoMapper todoMapper) {
    this.todoMapper = todoMapper;
  }

  public Todo get(Long id) {
    return todoMapper.get(id);
  }
}
