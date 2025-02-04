package com.x0x0b.piyo_todo_api.controller;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import com.x0x0b.piyo_todo_api.dto.attachment.web.AttachmentWebRequest;
import java.util.List;

public interface AttachmentWebController {

  List<AttachmentWeb> getList(Long todoId);

  void add(AttachmentWebRequest request, Long todoId);
}
