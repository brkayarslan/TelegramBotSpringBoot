FROM openjdk:17-jdk-alpine

VOLUME /tmp
COPY . .
RUN ./gradlew clean build
CMD ./gradlew bootRun
