package com.x0x0b.piyo_todo_api.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Todo {

  private Long id;
  private String title;
  private String description;
  private boolean completed;
  private List<Attachment> attachments;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
