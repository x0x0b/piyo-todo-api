package com.x0x0b.piyo_todo_api.repository

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb
import com.x0x0b.piyo_todo_api.repository.mapper.AttachmentWebMapper
import spock.lang.Specification

class AttachmentWebRepositorySpec extends Specification {

    AttachmentWebMapper attachmentWebMapper = Mock()
    AttachmentWebRepositoryImpl attachmentWebRepository = new AttachmentWebRepositoryImpl(attachmentWebMapper)

    def "test getList"() {
        given:
        Long todoId = 1L
        List<AttachmentWeb> mockAttachments = [new AttachmentWeb(todoId: todoId, url: "http://example.com")]
        1 * attachmentWebMapper.getByTodoId(todoId) >> mockAttachments

        when:
        List<AttachmentWeb> attachments = attachmentWebRepository.getList(todoId)

        then:
        attachments.size() == 1
        attachments[0].todoId == todoId
        attachments[0].url == "http://example.com"
    }

    def "test insert"() {
        given:
        Long todoId = 1L
        String url = "file_url"
        String name = "file_name"
        1 * attachmentWebMapper.insert(todoId, url, name) >> 1

        when:
        int result = attachmentWebRepository.insert(todoId, url, name)

        then:
        result == 1
    }

}
