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
        String originalFilename = "test.jpg"
        file.originalFilename >> originalFilename
        Long todoId = 1L
        1 * attachmentS3Repository.uploadToS3(_, file)
        1 * attachmentS3Repository.insert(_, originalFilename, todoId) >> 1

        when:
        attachmentS3Service.upload(file, todoId)

        then:
        noExceptionThrown()
    }
}
