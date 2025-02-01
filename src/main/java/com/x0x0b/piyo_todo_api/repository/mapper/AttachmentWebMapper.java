package com.x0x0b.piyo_todo_api.repository.mapper;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import java.util.List;

public interface AttachmentWebMapper {

  List<AttachmentWeb> getByTodoId(Long todoId);

}
