FROM openjdk:8-jdk-alpine
ENV LANG C.UTF-8
ARG JAR_FILE=target/spring_cloud_config.jar
VOLUME /tmp
ADD ${JAR_FILE} spring_cloud_config.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.ergd = file:/dev./urandom","-jar","/spring_cloud_config.jar"]
