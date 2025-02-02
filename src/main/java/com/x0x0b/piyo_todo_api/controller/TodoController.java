package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.domain.Todo;
import com.x0x0b.piyo_todo_api.dto.todo.TodoOperationRequest;

public interface TodoController {

  Todo get(Long id);

  void add(TodoOperationRequest token);

  void set(TodoOperationRequest token);
}
