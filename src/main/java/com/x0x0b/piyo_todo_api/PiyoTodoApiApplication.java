package com.x0x0b.piyo_todo_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.x0x0b.piyo_todo_api.repository.mapper")
public class PiyoTodoApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(PiyoTodoApiApplication.class, args);
  }

}
