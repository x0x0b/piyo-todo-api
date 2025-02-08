package com.x0x0b.piyo_todo_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x0x0b.piyo_todo_api.domain.enums.AttachmentType;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AttachmentBase {

  @JsonIgnore
  private Long id;
  @JsonIgnore
  private Long todoId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private AttachmentType type;
  private String name;
  private String url;

  public AttachmentBase(AttachmentType type) {
    this.type = type;
  }
}
