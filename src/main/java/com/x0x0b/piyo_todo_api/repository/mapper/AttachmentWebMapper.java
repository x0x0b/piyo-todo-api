package com.x0x0b.piyo_todo_api.repository.mapper;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachmentWebMapper {

  List<AttachmentWeb> getByTodoId(Long todoId);

  int insert(Long todoId, String url, String name);

}
