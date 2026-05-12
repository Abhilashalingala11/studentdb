FROM eclipse-temurin:17-jdk

EXPOSE 8080

ADD target/student-docker.jar student-docker.jar

ENTRYPOINT ["java","-jar","/student-docker.jar"]