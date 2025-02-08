package com.x0x0b.piyo_todo_api.service;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import com.x0x0b.piyo_todo_api.repository.AttachmentWebRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AttachmentWebServiceImpl implements AttachmentWebService {

  private final AttachmentWebRepository attachmentWebRepository;

  public AttachmentWebServiceImpl(AttachmentWebRepository attachmentWebRepository) {
    this.attachmentWebRepository = attachmentWebRepository;
  }

  @Override
  public List<AttachmentWeb> getList(Long todoId) {
    return attachmentWebRepository.getList(todoId);
  }

  @Override
  public void add(AttachmentWeb attachmentWeb) {
    attachmentWebRepository.insert(attachmentWeb.getTodoId(), attachmentWeb.getUrl());
  }

}
