package com.x0x0b.piyo_todo_api.repository

import com.x0x0b.piyo_todo_api.domain.AttachmentS3
import com.x0x0b.piyo_todo_api.domain.AttachmentWeb
import com.x0x0b.piyo_todo_api.domain.Todo
import com.x0x0b.piyo_todo_api.repository.mapper.AttachmentS3Mapper
import com.x0x0b.piyo_todo_api.repository.mapper.AttachmentWebMapper
import com.x0x0b.piyo_todo_api.repository.mapper.TodoMapper
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class TodoRepositorySpec extends Specification {

    TodoMapper todoMapper = Mock()
    AttachmentS3Mapper attachmentS3Mapper = Mock()
    AttachmentWebMapper attachmentWebMapper = Mock()
    TodoRepositoryImpl todoRepository = new TodoRepositoryImpl(todoMapper, attachmentS3Mapper, attachmentWebMapper)

    def "test getList"() {
        given:
        List<Todo> mockTodos = [new Todo()]
        todoMapper.getList() >> mockTodos

        when:
        List<Todo> todos = todoRepository.getList()

        then:
        todos == mockTodos
    }

    def "test get"() {
        given:
        Long todoId = 1L
        Todo mockTodo = new Todo(id: todoId)
        1 * todoMapper.get(todoId) >> mockTodo
        List<AttachmentS3> s3Attachments = [new AttachmentS3(id: 10L, todoId: todoId), new AttachmentS3(id: 11L, todoId: todoId)]
        List<AttachmentWeb> webAttachments = [new AttachmentWeb(id: 20L, todoId: todoId)]
        1 * attachmentS3Mapper.getByTodoId(todoId) >> s3Attachments
        1 * attachmentWebMapper.getByTodoId(todoId) >> webAttachments

        when:
        Todo todo = todoRepository.get(todoId)

        then:
        todo == mockTodo
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
