package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.domain.Todo;

public interface TodoController {

  Todo get(Long id);

  void add(Todo token);
}
