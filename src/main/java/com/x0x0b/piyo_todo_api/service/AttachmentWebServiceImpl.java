package com.x0x0b.piyo_todo_api.service;

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb;
import com.x0x0b.piyo_todo_api.repository.AttachmentWebRepository;
import org.springframework.stereotype.Service;

@Service
public class AttachmentWebServiceImpl implements AttachmentWebService {

  private final AttachmentWebRepository attachmentWebRepository;

  public AttachmentWebServiceImpl(AttachmentWebRepository attachmentWebRepository) {
    this.attachmentWebRepository = attachmentWebRepository;
  }

  public void add(AttachmentWeb attachmentWeb) {
    attachmentWebRepository.insert(attachmentWeb.getTodoId(), attachmentWeb.getUrl());
  }

}
