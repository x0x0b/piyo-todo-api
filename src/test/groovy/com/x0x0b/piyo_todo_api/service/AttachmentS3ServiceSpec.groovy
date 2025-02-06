package com.x0x0b.piyo_todo_api.service

import com.x0x0b.piyo_todo_api.domain.AttachmentS3
import com.x0x0b.piyo_todo_api.repository.AttachmentS3Repository
import org.springframework.web.multipart.MultipartFile
import spock.lang.Specification

class AttachmentS3ServiceSpec extends Specification {

    AttachmentS3Repository attachmentS3Repository = Mock()
    AttachmentS3ServiceImpl attachmentS3Service = new AttachmentS3ServiceImpl(attachmentS3Repository)

    def "test getList"() {
        given:
        Long todoId = 1L
        List<AttachmentS3> attachments = [new AttachmentS3(), new AttachmentS3()]
        attachmentS3Repository.getList(todoId) >> attachments

        when:
        List<AttachmentS3> result = attachmentS3Service.getList(todoId)

        then:
        result == attachments
    }

    def "test upload"() {
        given:
        MultipartFile file = Mock()
        Long todoId = 1L

        when:
        attachmentS3Service.upload(file, todoId)

        then:
        1 * attachmentS3Repository.upload(file, todoId)
    }

    def "test getPresignedUrl"() {
        given:
        String keyName = "test-key"
        String url = "http://example.com"
        attachmentS3Repository.getPresignedUrl(keyName) >> url

        when:
        String result = attachmentS3Service.getPresignedUrl(keyName)

        then:
        result == url
    }
}
