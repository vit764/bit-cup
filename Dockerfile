FROM maven:3.6.0-jdk-16 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:16-alpine
COPY --from=build /home/app/ /home/app/
RUN mv /home/app/target/bitcup-0.0.1-SNAPSHOT.jar /home/app/
ENTRYPOINT ["java","-jar","bit-cup-0.0.1-SNAPSHOT.jar","--spring.profiles.active=docker"]