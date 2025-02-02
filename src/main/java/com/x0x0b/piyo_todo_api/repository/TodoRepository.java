package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.domain.Todo;

public interface TodoRepository {

  Todo get(Long id);

  int add(Todo todo);

  int set(Todo todo);
}
