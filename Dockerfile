FROM eclipse-temurin:17-jre-alpine
LABEL authors="zjj20"
COPY ./target/toolbox-0.0.1-SNAPSHOT.jar toolbox.jar
CMD echo helloworld
ENTRYPOINT ["java", "-jar","toolbox.jar"]