CREATE TABLE IF NOT EXISTS attachments_s3
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    todo_id       BIGINT       NOT NULL,
    bucket_name   VARCHAR(255) NOT NULL,
    key_name      VARCHAR(255) NOT NULL,
    original_name VARCHAR(255) NOT NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (todo_id) REFERENCES todos (id)
);
