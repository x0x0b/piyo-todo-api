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
        List<AttachmentWeb> mockAttachments = [new AttachmentWeb()]
        1 * attachmentWebMapper.getByTodoId(todoId) >> mockAttachments

        when:
        List<AttachmentWeb> attachments = attachmentWebRepository.getList(todoId)

        then:
        attachments == mockAttachments
    }

    def "test insert"() {
        given:
        Long todoId = 1L
        String url = "file_url"
        1 * attachmentWebMapper.insert(todoId, url) >> 1

        when:
        attachmentWebRepository.insert(todoId, url)

        then:
        noExceptionThrown()
    }

}
