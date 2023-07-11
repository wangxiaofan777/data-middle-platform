FROM openjdk:8
LABEL authors="WangMaoSong"
MAINTAINER WangMaoSong


VOLUME /home/app

ENV TZ=Asia/Shanghai

ADD target/datasource-service-0.0.1-SNAPSHOT.jar /home/app/app.jar

RUN bash -c "touch /home/app/app.jar"

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/home/app/app.jar"]