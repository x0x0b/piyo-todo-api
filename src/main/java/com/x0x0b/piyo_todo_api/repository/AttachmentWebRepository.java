package com.x0x0b.piyo_todo_api.repository;

public interface AttachmentWebRepository {

  void insert(Long todoId, String url);
}
