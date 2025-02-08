package com.x0x0b.piyo_todo_api.service;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import com.x0x0b.piyo_todo_api.repository.AttachmentWebRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AttachmentWebServiceImpl implements AttachmentWebService {

  private final AttachmentWebRepository attachmentWebRepository;

  public AttachmentWebServiceImpl(AttachmentWebRepository attachmentWebRepository) {
    this.attachmentWebRepository = attachmentWebRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<AttachmentWeb> getList(Long todoId) {
    return attachmentWebRepository.getList(todoId);
  }

  @Override
  @Transactional
  public void add(AttachmentWeb attachmentWeb) {
    attachmentWebRepository.insert(attachmentWeb.getTodoId(), attachmentWeb.getUrl());
  }

}
