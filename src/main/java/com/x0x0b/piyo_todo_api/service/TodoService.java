package com.x0x0b.piyo_todo_api.service;

import com.x0x0b.piyo_todo_api.domain.Todo;
import java.util.List;

public interface TodoService {

  List<Todo> getList();

  Todo get(Long id);

  int add(Todo todo);

  int set(Todo todo);
}
