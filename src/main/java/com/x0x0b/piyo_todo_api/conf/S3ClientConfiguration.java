package com.x0x0b.piyo_todo_api.conf;

import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class S3ClientConfiguration {

  private S3Client s3;
  @Value("${piyo-todo.aws.s3.region:ap-northeast-1}")
  private Region region;
  @Value("${piyo-todo.aws.s3.presigned.access-key-id}")
  private String accessKeyId;
  @Value("${piyo-todo.aws.s3.presigned.secret-access-key}")
  private String secretAccessKey;

  @Bean
  @Profile("local")
  // ローカルではパススタイルのS3エンドポイントのみ使用可能
  public S3Client s3ClientLocal() {
    return S3Client.builder()
        .region(region)
        .endpointOverride(URI.create("http://localhost:4566"))
        .forcePathStyle(true)
        .build();
  }

  @Bean
  @Profile("!local")
  // 本番環境ではパススタイルのS3エンドポイントは使用不可
  public S3Client s3Client() {
    return S3Client.builder()
        .region(region)
        .forcePathStyle(false)
        .build();
  }

  @Bean
  public S3Presigner s3Presigner() {
    AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(
        AwsBasicCredentials.create(accessKeyId, secretAccessKey)
    );
    return S3Presigner.builder()
        .region(region)
        .credentialsProvider(credentialsProvider)
        .build();
  }
}
