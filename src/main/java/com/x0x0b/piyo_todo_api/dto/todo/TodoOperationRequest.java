package com.x0x0b.piyo_todo_api.dto.todo;

import lombok.Getter;

@Getter
public class TodoOperationRequest {

  private Long id;
  private String title;
  private String description;
  private boolean completed;
}
