package com.x0x0b.piyo_todo_api.conf;

import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3ClientConfiguration {

  private S3Client s3;
  @Value("${piyo-todo.aws.s3.region:ap-northeast-1}")
  private Region region;

  @Bean
  @Profile("local")
  public S3Client s3ClientLocal() {
    return S3Client.builder()
        .region(region)
        .endpointOverride(URI.create("http://localhost:4566"))
        .forcePathStyle(true)
        .build();
  }

  @Bean
  @Profile("!local")
  public S3Client s3Client() {
    return S3Client.builder()
        .region(region)
        .forcePathStyle(false)
        .build();
  }
}
