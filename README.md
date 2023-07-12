# data-middle-platform

数据中台

### 打包镜像

* 构建本地镜像

```shell
docker build . -t user-service:v1
docker build . -t datasource-service:v1

```

* 打包镜像并推送到镜像服务器

> 数据源服务

```shell
docker tag datasource-service:v1 wangxiaofan777/datasource-service:v1
docker push wangxiaofan777/datasource-service:v1
```

> 用户服务

```shell
docker tag user-service:v1 wangxiaofan777/user-service:v1
docker push wangxiaofan777/user-service:v1

```
