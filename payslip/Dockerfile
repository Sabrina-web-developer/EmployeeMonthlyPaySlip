# docker build -t springio/gs-spring-boot-docker .
# docker run -p 8081:8081 springio/gs-spring-boot-docker

FROM openjdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

