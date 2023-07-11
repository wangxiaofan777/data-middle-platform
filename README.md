# data-middle-platform

数据中台

* 构建本地镜像

```shell
docker build . -t user-service:v1
docker build . -t datasource-service:v1

```

* 推送到远程服务

```shell
docker push wangxiaofan777/data-middle-platform:user-service
docker push wangxiaofan777/data-middle-platform:datasource-service

```