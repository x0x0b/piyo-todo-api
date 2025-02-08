package com.x0x0b.piyo_todo_api.domain;

import com.x0x0b.piyo_todo_api.domain.enums.AttachmentType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AttachmentWeb extends AttachmentBase implements Attachment {

  public AttachmentWeb() {
    super(AttachmentType.WEB);
  }
}
