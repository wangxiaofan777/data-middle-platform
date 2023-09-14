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

* MySQL连接

```shell
# JVM 参数配置
-Djava.net.preferIPv4Stack=true
```

channels:

- https://mirrors.tuna.tsinghua.edu.cn/anaconda/pkgs/free/
- https://mirrors.tuna.tsinghua.edu.cn/anaconda/cloud/conda-forge/
- https://mirrors.tuna.tsinghua.edu.cn/anaconda/cloud/msys2/
- defaults
  show_channel_urls: true

envs_dirs:

- /Users/wangmaosong/data/anaconda3/envs
  pkgs_dirs:
- /Users/wangmaosong/data/anaconda3/pkgs

### redis-cluster安装

* 创建配置数据路径

```shell
mkdir -p /data/redis/data/7000/data
mkdir -p /data/redis/data/7001/data
mkdir -p /data/redis/data/7002/data
mkdir -p /data/redis/data/7003/data
mkdir -p /data/redis/data/7004/data
mkdir -p /data/redis/data/7005/data
mkdir -p /data/redis/data/7006/data

```

* 创建日志路径

```shell
mkdir -p /data/redis/data/7000/logs
mkdir -p /data/redis/data/7001/logs
mkdir -p /data/redis/data/7002/logs
mkdir -p /data/redis/data/7003/logs
mkdir -p /data/redis/data/7004/logs
mkdir -p /data/redis/data/7005/logs
mkdir -p /data/redis/data/7006/logs
```

* 创建配置文件

> > 配置文件需要创建六个，修改为不同的端口即可（7000、7001、7002、7003、7004、7005、7006）

```shell
port 7000
# 默认绑定
bind 0.0.0.0
# 是否守护进程启动
daemonize yes
# 日志级别：notice或者debug(开发)
loglevel notice
# 日志文件
logfile "/data/redis/data/7000/logs/redis_7000.log"
# data路径
dir /data/redis/data/7000/data
# 线程
pidfile /var/run/redis_7000.pid
# 开启日志Append
appendonly yes

maxmemory 2gb
# aof文件名
appendfilename "appendonly.aof"
# 同步写入策略 always、everysec、no
appendfsync everysec

protected-mode no

cluster-enabled yes

# RDB
save 900 1
save 300 10
save 60 10000
# rdb文件名
dbfilename dump.rdb
# Redis默认是开启压缩的。
rdbcompression yes
# 用户密码
#user admin on -DEBUG +@all ~* > 123456
#requirepass 123456
#replicaof 127.0.0.1= 6379
replica-read-only no
# 删除策略
maxmemory-policy volatile-lru

```

* 启动服务

```shell
redis-server /etc/redis/7000.conf
redis-server /etc/redis/7001.conf
redis-server /etc/redis/7002.conf
redis-server /etc/redis/7003.conf
redis-server /etc/redis/7004.conf
redis-server /etc/redis/7005.conf
redis-server /etc/redis/7006.conf

```

* 创建redis集群

> > 创建成功会有提示：[OK] All 16384 slots covered.

```redis
redis-cli --cluster create 127.0.0.1:7000 127.0.0.1:7001 \
127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005 \
--cluster-replicas 1
```

# 添加节点

> > 添加成功会有如下提示：[OK] New node added correctly.

```redis
redis-cli --cluster add-node 127.0.0.1:7006 127.0.0.1:7000
```

# 删除节点

```shell
redis-cli --cluster del-node 127.0.0.1:7006 2873e8480bbfca1b0b98621e7862f6844a6e5850
```