FROM amazoncorretto:17-alpine-jdk
MAINTAINER NCH
COPY target/forohub-0.0.1-SNAPSHOT.jar forohub-back.jar
ENTRYPOINT ["java","-jar","/forohub-back.jar"]