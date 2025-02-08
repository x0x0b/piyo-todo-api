package com.x0x0b.piyo_todo_api.service

import com.x0x0b.piyo_todo_api.domain.AttachmentWeb
import com.x0x0b.piyo_todo_api.repository.AttachmentWebRepository
import spock.lang.Specification

class AttachmentWebServiceSpec extends Specification {

    AttachmentWebRepository attachmentWebRepository = Mock()
    AttachmentWebServiceImpl attachmentWebService = new AttachmentWebServiceImpl(attachmentWebRepository)

    def "test getList"() {
        given:
        Long todoId = 1L
        List<AttachmentWeb> attachments = [new AttachmentWeb(), new AttachmentWeb()]
        attachmentWebRepository.getList(todoId) >> attachments

        when:
        List<AttachmentWeb> result = attachmentWebService.getList(todoId)

        then:
        result == attachments
    }

    def "test add"() {
        given:
        AttachmentWeb attachmentWeb = new AttachmentWeb(todoId: 1L, url: "http://example.com", name: "example")
        1 * attachmentWebRepository.insert(attachmentWeb.getTodoId(), attachmentWeb.getUrl(), attachmentWeb.getName()) >> 1

        when:
        int result = attachmentWebService.add(attachmentWeb)

        then:
        result == 1
    }
}
