package com.x0x0b.piyo_todo_api.repository

import com.x0x0b.piyo_todo_api.domain.AttachmentS3
import com.x0x0b.piyo_todo_api.repository.mapper.AttachmentS3Mapper
import org.springframework.web.multipart.MultipartFile
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.S3Exception
import software.amazon.awssdk.services.s3.presigner.S3Presigner
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest
import spock.lang.Specification

class AttachmentS3RepositorySpec extends Specification {

    AttachmentS3Mapper attachmentS3Mapper = Mock()
    S3Client s3Client = Mock()
    S3Presigner s3Presigner = Mock()
    AttachmentS3RepositoryImpl attachmentS3Repository = new AttachmentS3RepositoryImpl(attachmentS3Mapper, s3Client, s3Presigner)

    def "test getList"() {
        given:
        Long todoId = 1L
        List<AttachmentS3> mockAttachments = [new AttachmentS3(todoId: 1L, keyName: "key", name: "filename")]
        1 * attachmentS3Mapper.getByTodoId(todoId) >> mockAttachments
        PresignedGetObjectRequest presignedGetObjectRequest = Mock()
        1 * s3Presigner.presignGetObject(_) >> presignedGetObjectRequest
        1 * presignedGetObjectRequest.url() >> new URI("http://example.com").toURL()

        when:
        List<AttachmentS3> attachments = attachmentS3Repository.getList(todoId)

        then:
        attachments.size() == 1
        attachments[0].todoId == todoId
        attachments[0].keyName == "key"
        attachments[0].name == "filename"
        attachments[0].url == "http://example.com"

    }

    def "test insert"() {
        given:
        String keyName = "key"
        String originalFilename = "filename"
        Long todoId = 1L
        1 * attachmentS3Mapper.insert(_, keyName, originalFilename, todoId) >> 1

        when:
        int result = attachmentS3Repository.insert(keyName, originalFilename, todoId)

        then:
        result == 1
    }

    def "test uploadToS3"() {
        given:
        String keyName = "key"
        MultipartFile file = Mock()
        file.getBytes() >> new byte[0]
        1 * s3Client.putObject(_, _) >> null

        when:
        attachmentS3Repository.uploadToS3(keyName, file)

        then:
        noExceptionThrown()
    }

    def "test uploadToS3 Exception"() {
        given:
        String keyName = "key"
        MultipartFile file = Mock()
        file.getBytes() >> new byte[0]
        1 * s3Client.putObject(_, _) >> { throw exception }

        when:
        attachmentS3Repository.uploadToS3(keyName, file)

        then:
        thrown(RuntimeException)

        where:
        exception << [S3Exception.builder().message("error"), new RuntimeException()]
    }

    def "test getPresignedUrl"() {
        given:
        String keyName = "key"
        String originalFileName = "original"
        String url = "http://example.com"
        PresignedGetObjectRequest presignedGetObjectRequest = Mock()
        1 * s3Presigner.presignGetObject(_) >> presignedGetObjectRequest
        1 * presignedGetObjectRequest.url() >> new URI(url).toURL()

        when:
        String presignedUrl = attachmentS3Repository.getPresignedUrl(keyName, originalFileName)

        then:
        presignedUrl == url
    }
}
