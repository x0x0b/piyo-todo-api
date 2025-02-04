package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.domain.Todo;
import java.util.List;

public interface TodoRepository {

  List<Todo> getList();

  Todo get(Long id);

  int add(Todo todo);

  int set(Todo todo);
}
