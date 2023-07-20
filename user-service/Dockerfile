FROM openjdk:8
LABEL authors="WangXiaofan777"
MAINTAINER WangXiaofan777

VOLUME /home/app

ENV TZ=Asia/Shanghai

ADD target/user-service-0.0.1-SNAPSHOT.jar /home/app/app.jar

RUN bash -c "touch /home/app/app.jar"

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/home/app/app.jar"]