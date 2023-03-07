FROM openjdk:8-jdk-alpine
ENV LANG C.UTF-8
ARG JAR_FILE=target/eureka.jar
VOLUME /tmp
ADD ${JAR_FILE} eureka.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd = file:/dev./urandom","-jar","/eureka.jar"]
