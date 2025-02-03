package com.x0x0b.piyo_todo_api.repository;

import com.x0x0b.piyo_todo_api.repository.mapper.AttachmentS3Mapper;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Repository
@Slf4j
public class AttachmentS3RepositoryImpl implements AttachmentS3Repository {

  private final AttachmentS3Mapper attachmentS3Mapper;
  private final S3Client s3;

  @Value("${piyo-todo.aws.s3.bucket}")
  private String bucketName;

  public AttachmentS3RepositoryImpl(AttachmentS3Mapper attachmentS3Mapper, S3Client s3) {
    this.attachmentS3Mapper = attachmentS3Mapper;
    this.s3 = s3;
  }

  @Override
  public void insert(String keyName, String originalFilename, Long todoId) {
    attachmentS3Mapper.insert(bucketName, keyName, originalFilename, todoId);
  }

  @Override
  public void uploadToS3(String keyName, MultipartFile file) {
    try {
      PutObjectRequest request = PutObjectRequest.builder()
          .bucket(bucketName)
          .key(keyName)
          .build();

      s3.putObject(request, RequestBody.fromBytes(file.getBytes()));
    } catch (S3Exception | IOException e) {
      log.error("Failed to upload file to S3", e);
      throw new RuntimeException(e);
    }
  }
}
