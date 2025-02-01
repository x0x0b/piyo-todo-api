package com.x0x0b.piyo_todo_api.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AttachmentBase {

  private Long id;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}
