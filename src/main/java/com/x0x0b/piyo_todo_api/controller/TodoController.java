package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.domain.Todo;
import com.x0x0b.piyo_todo_api.dto.todo.TodoOperationRequest;
import java.util.List;

public interface TodoController {

  List<Todo> getList();

  Todo get(Long todoId);

  void add(TodoOperationRequest token);

  void set(TodoOperationRequest token);
}
