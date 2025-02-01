package com.x0x0b.piyo_todo_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x0x0b.piyo_todo_api.enums.AttachmentType;
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
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private AttachmentType type;

  public AttachmentBase(AttachmentType type) {
    this.type = type;
  }
}
