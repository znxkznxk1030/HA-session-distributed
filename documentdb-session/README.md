# DocumentDB Session

## Mongodb

```bash
brew services start mongodb-community@5.0
brew services stop mongodb-community@5.0
```

## SSL

SSL CERTS

```bash
wget https://s3.amazonaws.com/rds-downloads/rds-combined-ca-bundle.pem
```

## Docker

```bash
docker build -t documentdb-session .
docker run --name demo -e SPRING_DATA_MONGODB_URI=mongodb://arthurkim:rla8292$%^@docdb-2022-03-25-05-23-47.cluster-cbnctkmnqiqo.ap-northeast-2.docdb.amazonaws.com:27017/?ssl=true&ssl_ca_certs=rds-combined-ca-bundle.pem&replicaSet=rs0&readPreference=secondaryPreferred&retryWrites=false  -e JAVA_OPTS="-DsslCertificate=./ssl/rds-combined-ca-bundle.pem" documentdb-session
docker stop demo && docker rm demo
```
