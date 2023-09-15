FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY --from=build target/eazipayTask-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]


#RUN addgroup -S app && adduser -S app -G app
#
#USER app
#
#COPY target/*jar app.jar
#
#ENTRYPOINT ["java", "-jar", "/app.jar"]q