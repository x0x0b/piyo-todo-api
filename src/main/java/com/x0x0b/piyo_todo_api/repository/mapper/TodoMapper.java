package com.x0x0b.piyo_todo_api.repository.mapper;

import com.x0x0b.piyo_todo_api.domain.Todo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {

  Todo get(Long id);

}
