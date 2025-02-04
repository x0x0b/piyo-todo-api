package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import java.util.List;

public interface AttachmentWebRepository {

  List<AttachmentWeb> getList(Long todoId);

  void insert(Long todoId, String url);
}
