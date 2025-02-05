# piyo-todo-api

構成等については Wiki に記載  
https://github.com/x0x0b/piyo-todo-api/wiki

## ローカル実行

以下でMySQL, AWSサーバ(LocalStack)が起動します。

```bash
$ docker-compose up
```

MySQLの初期化スクリプトはボリューム作成後の初回のみ実行されます。
初期化が必要な場合は以下でボリュームを削除してください。

```bash
$ docker-compose down -v
```

ローカル実行時はプロファイル `local` を指定してください。

```bash
export SPRING_PROFILES_ACTIVE=local
```

以下で Swagger UI が確認可能。  
http://localhost:8080/swagger-ui/index.html
