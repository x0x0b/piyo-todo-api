package com.x0x0b.piyo_todo_api.service;

import com.x0x0b.piyo_todo_api.domain.Todo;
import com.x0x0b.piyo_todo_api.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;

  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public Todo get(Long id) {
    return todoRepository.get(id);
  }

}
