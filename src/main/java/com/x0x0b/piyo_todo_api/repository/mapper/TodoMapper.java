package com.x0x0b.piyo_todo_api.repository.mapper;

import com.x0x0b.piyo_todo_api.domain.Todo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

  List<Todo> getList();

  Todo get(Long id);

  int add(Todo todo);

  int set(Todo todo);
}
