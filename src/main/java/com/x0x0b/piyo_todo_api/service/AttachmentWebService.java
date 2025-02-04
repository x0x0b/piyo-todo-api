package com.x0x0b.piyo_todo_api.service;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import java.util.List;

public interface AttachmentWebService {

  List<AttachmentWeb> getList(Long todoId);

  void add(AttachmentWeb attachmentWeb);

}
