package com.x0x0b.piyo_todo_api.service

import com.x0x0b.piyo_todo_api.domain.Todo
import com.x0x0b.piyo_todo_api.repository.TodoRepository
import spock.lang.Specification

class TodoServiceSpec extends Specification {

    TodoRepository todoRepository = Mock()
    TodoServiceImpl todoService = new TodoServiceImpl(todoRepository)

    def "test getList"() {
        given:
        List<Todo> todos = [new Todo(), new Todo()]
        todoRepository.getList() >> todos

        when:
        List<Todo> result = todoService.getList()

        then:
        result == todos
    }

    def "test get"() {
        given:
        Long id = 1L
        Todo todo = new Todo()
        todoRepository.get(id) >> todo

        when:
        Todo result = todoService.get(id)

        then:
        result == todo
    }

    def "test get null"() {
        given:
        Long id = 1L
        todoRepository.get(id) >> null

        when:
        todoService.get(id)

        then:
        thrown(RuntimeException)
    }

    def "test add"() {
        given:
        Todo todo = new Todo()
        int rowsAffected = 1
        todoRepository.add(todo) >> rowsAffected

        when:
        int result = todoService.add(todo)

        then:
        result == rowsAffected
    }

    def "test set"() {
        given:
        Todo todo = new Todo()
        int rowsAffected = 1
        todoRepository.set(todo) >> rowsAffected

        when:
        int result = todoService.set(todo)

        then:
        result == rowsAffected
    }
}
