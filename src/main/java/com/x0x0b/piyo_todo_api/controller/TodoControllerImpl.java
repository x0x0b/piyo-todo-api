package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.domain.Todo;
import com.x0x0b.piyo_todo_api.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoControllerImpl implements TodoController {

  private final TodoService todoService;

  public TodoControllerImpl(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/get/{id}")
  public Todo get(@PathVariable("id") Long id) {
    return todoService.get(id);
  }
}
