package com.x0x0b.piyo_todo_api.repository

import com.x0x0b.piyo_todo_api.domain.AttachmentS3
import com.x0x0b.piyo_todo_api.domain.AttachmentWeb
import com.x0x0b.piyo_todo_api.domain.Todo
import com.x0x0b.piyo_todo_api.repository.mapper.TodoMapper
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class TodoRepositorySpec extends Specification {

    TodoMapper todoMapper = Mock()
    AttachmentS3Repository s3Repository = Mock()
    AttachmentWebRepository webRepository = Mock()
    TodoRepositoryImpl todoRepository = new TodoRepositoryImpl(todoMapper, s3Repository, webRepository)

    def "test getList"() {
        given:
        List<Todo> mockTodos = [new Todo(id: 1L), new Todo(id: 2L)]
        todoMapper.getList() >> mockTodos
        List<AttachmentS3> s3Attachments = [new AttachmentS3(id: 10L, todoId: 1L), new AttachmentS3(id: 11L, todoId: 1L)]
        List<AttachmentWeb> webAttachments = [new AttachmentWeb(id: 20L, todoId: 1L)]
        1 * s3Repository.getList(1L) >> s3Attachments
        1 * webRepository.getList(1L) >> webAttachments
        1 * s3Repository.getList(2L) >> []
        1 * webRepository.getList(2L) >> []

        when:
        List<Todo> todos = todoRepository.getList()

        then:
        todos.size() == 2
        todos[0].attachments.size() == 3
        todos[0].attachments.containsAll(s3Attachments + webAttachments)
        todos[1].attachments.size() == 0
    }

    def "test get"() {
        given:
        Long todoId = 1L
        Todo mockTodo = new Todo(id: todoId)
        1 * todoMapper.get(todoId) >> mockTodo
        List<AttachmentS3> s3Attachments = [new AttachmentS3(id: 10L, todoId: todoId), new AttachmentS3(id: 11L, todoId: todoId)]
        List<AttachmentWeb> webAttachments = [new AttachmentWeb(id: 20L, todoId: todoId)]
        1 * s3Repository.getList(todoId) >> s3Attachments
        1 * webRepository.getList(todoId) >> webAttachments

        when:
        Todo todo = todoRepository.get(todoId)

        then:
        todo.id == todoId
        todo.attachments.size() == 3
        todo.attachments.containsAll(s3Attachments + webAttachments)
    }

    def "test add"() {
        given:
        Todo todo = new Todo(title: "New Todo", description: "Description")
        1 * todoMapper.add(todo) >> 1

        when:
        int result = todoRepository.add(todo)

        then:
        result == 1
    }

    def "test set"() {
        given:
        Todo todo = new Todo(id: 1L, title: "Updated Todo", description: "Updated Description")
        1 * todoMapper.set(todo) >> 1

        when:
        int result = todoRepository.set(todo)

        then:
        result == 1
    }
}
