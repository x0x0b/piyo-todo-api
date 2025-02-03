# piyo-todo-api

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

ローカル実行時はプロファイル `dev` を指定してください。

```bash
export SPRING_PROFILES_ACTIVE=dev
```
