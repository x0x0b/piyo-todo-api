package com.x0x0b.piyo_todo_api.service;

import com.x0x0b.piyo_todo_api.domain.Todo;
import com.x0x0b.piyo_todo_api.repository.TodoRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;

  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Todo> getList() {
    return todoRepository.getList();
  }

  @Override
  @Transactional(readOnly = true)
  public Todo get(Long id) {
    Todo todo = todoRepository.get(id);
    if (todo == null) {
      throw new RuntimeException("Todo not found");
    }
    return todo;
  }

  @Override
  @Transactional
  public int add(Todo todo) {
    return todoRepository.add(todo);
  }

  @Override
  @Transactional
  public int set(Todo todo) {
    return todoRepository.set(todo);
  }
}
